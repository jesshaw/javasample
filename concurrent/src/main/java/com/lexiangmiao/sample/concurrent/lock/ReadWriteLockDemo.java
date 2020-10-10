package com.lexiangmiao.sample.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源没有作何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * <p>
 * 小总结：
 * 读-读能共享
 * 读-写不能共存
 * 写-写不能共存
 */

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    //private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：key = [" + key + "], value = [" + value + "]");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：key = [" + key + "], value = [" + value + "]");
        } finally {
            rwLock.writeLock().unlock();
        }
    }



    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：key = [" + key + "]");
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：key = [" + key + "], value = [" + value + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            rwLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }

    }
}
