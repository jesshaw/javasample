package com.lexiangmiao.sample.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：synchronized和Lock的区别？用新的Lock有什么好处？举例说明
 * 1 原始构成
 * synchronized是关键字属于JVM层面
 * monitorenter
 * monitorexit
 * Lock是具体类是API层的锁
 * 2 使用方法
 * synchronized不需要用户去手动释放锁，当synchronized代码执行完后系统会自动让线程释放对锁的占用
 * ReentrantLock则需要用户去手动释放锁，若没有主动释放锁，就可能导致出现死锁的现象。
 * 需要lock()各unlock()方法配合try/finally语句块来完成。
 * 3 等待是否可中断
 * synchronized不可中断，除非抛出异常或者正常运行完成
 * ReentrantLock可中断，1. 设置超时方法trylock(long timeout,TimeUnit unit)
 * 2. lockInterruptibly()放代码块中，调用interrput()方法中断
 * 4 加锁是否公平
 * synchronized非公平锁
 * ReentrantLock两者都可以，默认为非公平锁
 * 5 锁绑定多个条件Condition
 * synchronized没有
 * ReentrantLock用来实现分组唤醒的线程们，可以精确唤醒，而不是synchronized要么随机唤醒一个线程要么唤醒全部线程
 * <p>
 * ==================================================================================================
 * <p>
 * 题目： 多线程之间按顺序调用，实现A-》B-》C三线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......
 * 来10轮
 */
class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1 判定
            while (number != 1) {
                c1.await();
            }

            // 2 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);

            }
            // 3 通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1 判定
            while (number != 2) {
                c2.await();
            }

            // 2 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);

            }
            // 3 通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1 判定
            while (number != 3) {
                c3.await();
            }

            // 2 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);

            }
            // 3 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "t2").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "t3").start();
    }
}
