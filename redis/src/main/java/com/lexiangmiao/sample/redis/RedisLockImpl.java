package com.lexiangmiao.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLockImpl implements RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        boolean lock = false;
        if (threadLocal.get() == null) {
            String uuid = UUID.randomUUID().toString();
            threadLocal.set(uuid);
            lock = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
            while (!lock) { //自旋锁
                lock = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
                if (lock) {
                    break;
                }
            }
        } else if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            lock = true;
        }

        return lock;
    }

    @Override
    public void releaseLock(String key) {
        if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            stringRedisTemplate.delete(key);
        }
    }
}
