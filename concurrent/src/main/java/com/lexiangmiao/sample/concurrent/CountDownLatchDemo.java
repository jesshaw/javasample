package com.lexiangmiao.sample.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭");
                countDownLatch.countDown();
            }, Country.to(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ***** 秦帝国，一充华夏");

    }

    public static void closeRoom() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ***** 班长最后关门");
    }
}
