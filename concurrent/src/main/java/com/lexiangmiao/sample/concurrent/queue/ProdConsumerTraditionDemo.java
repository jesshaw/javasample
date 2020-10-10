package com.lexiangmiao.sample.concurrent.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 *
 * 1 线程  操作 资源类
 * 2 判断  干活 通知
 * 3 虚假唤醒
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        },"t3").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        },"t4").start();
    }
}

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            // 1 判断
            while (number != 0) { //多线程判断必须得用循环判断，否则超过2线程时会存在虚假唤醒的问题
                //等待，不能生产
                condition.await();
            }
            // 2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            // 1 判断
            while (number == 0) { //多线程判断必须得用循环判断，否则超过2线程时会存在虚假唤醒的问题
                //等待，不能生产
                condition.await();
            }
            // 2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
