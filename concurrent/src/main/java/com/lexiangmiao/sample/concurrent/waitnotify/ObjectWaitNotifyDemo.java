package com.lexiangmiao.sample.concurrent.waitnotify;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ref: https://segmentfault.com/a/1190000019104391?utm_source=sf-related
 * 基础知识
 * public final native void notify();
 * public final native void notifyAll();
 * public final native void wait(long timeout) throws InterruptedException;
 * public final void wait() throws InterruptedException {
 * wait(0);
 * }
 * 用法：
 * 调用以上方法必须得获取对象锁，因此就得配合synchronized关键字来使用
 * synchronized (object) {
 * while (condition) {
 * object.wait();
 * }
 * object.notify();
 * object.notifyAll();
 * }
 * <p>
 * public synchronized void methodName() {
 * while (condition) {
 * object.wait();
 * }
 * object.notify();
 * object.notifyAll();
 * }
 * <p>
 * 方法	作用
 * wait	线程自动释放占有的对象锁，并等待notify。
 * notify	随机唤醒一个正在wait当前对象的线程，并让被唤醒的线程拿到对象锁
 * notifyAll	唤醒所有正在wait当前对象的线程，但是被唤醒的线程会再次去竞争对象锁。因为一次只有一个线程能拿到锁，所有其他没有拿到锁的线程会被阻塞。推荐使用。
 */
public class ObjectWaitNotifyDemo {
    public static final Integer MAX_CAPACITY = 5;
    public static final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public static Boolean run = true;

    public static void main(String[] args) {
        ObjectWaitNotifyDemo objectWaitNotifyDemo = new ObjectWaitNotifyDemo();
        Producter p = objectWaitNotifyDemo.new Producter();
        p.start();
        Consumer c = objectWaitNotifyDemo.new Consumer();
        c.start();
    }

     class Producter extends Thread {
        @Override
        public void run() {
            while (run) {
                synchronized (queue) {
                    while (queue.size() >= MAX_CAPACITY * 2) {
                        System.out.println("缓冲队列已满，等待消费");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {

                        String str = UUID.randomUUID().toString();
                        queue.put(str);
                        System.out.println("生产：" + str);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notifyAll(); //通知生产者和消费者
                }
            }
        }
    }

     class Consumer extends Thread {
        @Override
        public void run() {
            while (run) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("队列为空，等持生产");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {

                        System.out.println("消费：" + queue.take());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notifyAll(); //通知生产者和消费者
                }
            }
        }
    }

}
