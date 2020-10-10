package com.lexiangmiao.sample.concurrent.atomicreference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,0);
    public static void main(String[] args) {
        System.out.println("-------------------以下是ABA问题的产生-------------------------");
        // 前情：以下两线程不一定t1线程先进行
        new Thread(()->{
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        },"t1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------以下是ABA问题的解决-------------------------");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 第1次版本号：" + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第2次版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第3次版本号：" + atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第1次版本号：" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          boolean result=  atomicStampedReference.compareAndSet(101, 2019,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t 修改成功否："+result+"\t 当前版本号：" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前值" + atomicStampedReference.getReference());
        },"t4").start();


    }
}
