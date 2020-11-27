package com.lexiangmiao.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLockImpl implements RedisLock {
    public static final String split = ":";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static Thread findThread(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group != null) {
            Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for (int i = 0; i < count; i++) {
                if (threadId == threads[i].getId()) {
                    return threads[i];
                }
            }
            
            group = group.getParent();
        }
        return null;
    }

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        boolean lock = false;
        if (threadLocal.get() == null) {

            // 异步续命
            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (!Thread.interrupted()) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("renew the time ...");
                        stringRedisTemplate.expire(key, timeout, unit);
                    }
                    System.out.println("renew stop ...");
                }
            };

            String uuid = thread.getId() + split + UUID.randomUUID().toString();
            threadLocal.set(uuid);
            lock = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
            while (!lock) { //自旋锁
                lock = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
                if (lock) {
                    break;
                }
            }

            thread.start(); //拿到锁的线程才会启动续命线程


        } else if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            lock = true;
        }

        return lock;
    }

    @Override
    public void releaseLock(String key) {
        if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            Thread thread = findThread(Long.parseLong(threadLocal.get().split(split)[0]));
            if (thread != null) {
                thread.interrupt();
            }
            stringRedisTemplate.delete(key);
        }
    }
}
