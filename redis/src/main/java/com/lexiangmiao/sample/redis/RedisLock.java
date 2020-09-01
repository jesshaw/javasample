package com.lexiangmiao.sample.redis;

import java.util.concurrent.TimeUnit;

/**
 *
 *         互斥性
 *         超时 解决断电或kill
 *         支持阻塞非阻塞
 *
 */
public interface RedisLock {
    boolean tryLock(String key, long timeout, TimeUnit unit);

    void releaseLock(String key);
}
