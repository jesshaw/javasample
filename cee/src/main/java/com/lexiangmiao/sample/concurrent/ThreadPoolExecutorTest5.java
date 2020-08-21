package com.lexiangmiao.sample.concurrent;

/**
 * Created by mzxiao on 2020/8/10 14:35
 */
public class ThreadPoolExecutorTest5  extends Thread  {
    int j;
    public ThreadPoolExecutorTest5(int v) {
        j = v;
    }

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        Thread thread1 = new ThreadPoolExecutorTest5(i);

        Thread thread2 = new ThreadPoolExecutorTest5(i);

        thread1.start();
        thread2.start();
        thread1.run();
        thread2.run();
        System.out.println(" " + i);
        
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            j++;
            System.out.println(""+j);
        }
    }
}
