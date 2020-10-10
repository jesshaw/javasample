package com.lexiangmiao.sample.concurrent.volatilekey;

/**
 * 验证volatile不保证原子性（不可分割，完整性）
 *
 * 如何解决呢？
 * 1. 方法加synchronized （杀鸡焉用牛刀）
 * 2. AtomicInteger (自旋锁和CAS)
 */
public class Synchronization {

    volatile int number = 0;

    public static void main(String[] args) {
        Synchronization myData = new Synchronization();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPuls();
                }
            }, String.valueOf(i)).start();
        }


        //线程大于2说明还在跑上面的程序
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally the number value:" + myData.number);
    }

    public  void addPlusPuls() {
        this.number++;
    }


}
