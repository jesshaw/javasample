package com.lexiangmiao.sample.concurrent.volatilekey;

import java.util.concurrent.TimeUnit;

/**
 * volatile一致性验证。
 * 加了volatile正常运行完成，不加的话因读取不到thread A的number数据因此不可见
 */
public class MemoryVisibility {

    //    int number = 0;
    volatile int number = 0;

    public static void main(String[] args) {
        MemoryVisibility myData = new MemoryVisibility();

        System.out.println("the number value:" + myData.number);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in the number");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        }, "thread a").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

    public void addTo60() {
        this.number = 60;
    }
}
