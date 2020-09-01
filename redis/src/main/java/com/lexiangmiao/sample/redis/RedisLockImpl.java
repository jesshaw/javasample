package com.lexiangmiao.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLockImpl implements RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(key, "ant", timeout, unit);
        while (!lock) { //自旋锁
            lock = stringRedisTemplate.opsForValue().setIfAbsent(key, "ant", timeout, unit);
            if (lock) {
                break;
            }
        }
        return lock;
    }

    @Override
    public void releaseLock(String key) {
        stringRedisTemplate.delete(key);
    }
}
