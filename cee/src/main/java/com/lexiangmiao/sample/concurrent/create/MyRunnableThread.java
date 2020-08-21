package com.lexiangmiao.sample.concurrent.create;

/**
 * Created by mzxiao on 2020/7/24 15:56
 */
public class MyRunnableThread implements Runnable {
    public static void main(String[] args) {
        System.out.println("main thread id is " + Thread.currentThread().getId());
        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("MyRunnableThread thread id is " + Thread.currentThread().getId());
    }
}
