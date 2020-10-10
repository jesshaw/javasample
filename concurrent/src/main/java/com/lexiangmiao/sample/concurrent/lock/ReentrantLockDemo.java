package com.lexiangmiao.sample.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 指的是同一线程外层方法获得锁之后，内层递归方法仍然能获取该锁，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * <p>
 * <p>
 * 11	 invoked sendSMS()
 * 11	 ******** invoked sendEmail()
 * 12	 invoked sendSMS()
 * 12	 ******** invoked sendEmail()
 */
class PhoneSynchronized {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId() + "\t synchronized invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t ******** synchronized invoked sendEmail()");
    }
}
class PhoneReentrantLock implements Runnable {
    Lock lock = new ReentrantLock();

    public synchronized void sendSMS() {
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getId() + "\t ReentrantLock invoked sendSMS()");
            sendEmail();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void sendEmail() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t ******** ReentrantLock invoked sendEmail()");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        sendSMS();
    }
}
public class ReentrantLockDemo {

    public static void main(String[] args) {
        PhoneSynchronized phone = new PhoneSynchronized();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();

        PhoneReentrantLock phoneReentrantLock = new PhoneReentrantLock();
        Thread t3 = new Thread(phoneReentrantLock);
        Thread t4 = new Thread(phoneReentrantLock);
        t3.start();
        t4.start();
    }
}
