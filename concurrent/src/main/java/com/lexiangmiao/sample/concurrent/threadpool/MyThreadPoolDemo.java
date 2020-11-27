package com.lexiangmiao.sample.concurrent.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
                System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        // 模拟10个用户佃理业务，每个用户就是一个请求线程

        try {
            for (int i = 1; i <= 10; i++) {

                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }


    public static void threadPoolInit(){
        //查看 cpu核数
//        System.out.println(Runtime.getRuntime().availableProcessors());
        // Array Arrays
        // Collection Collections
        // Executor Executors

//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //一个银行5个办理柜台
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //周末银行只开一个办理柜台
        ExecutorService threadPool = Executors.newCachedThreadPool(); //周末银行突然很多人，行长叫了一些人来加班
//        ExecutorService threadPool = Executors.newScheduledThreadPool(2); //创建一个定长线程池，支持定时及周期性任务执行。


        // 模拟10个用户佃理业务，每个用户就是一个请求线程

        try {
            for (int i = 1; i <= 20; i++) {

                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
