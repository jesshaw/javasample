package com.lexiangmiao.sample.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("********** come in Callable");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());


        new Thread(futureTask,"t1").start();
        new Thread(futureTask,"t2").start();


        System.out.println(Thread.currentThread().getName()+"******************");
        int result01 = 100;

        while (!futureTask.isDone()) {
        }

        int result02 = futureTask.get();
        System.out.println("****** result:" + (result01+result02));
    }
}
