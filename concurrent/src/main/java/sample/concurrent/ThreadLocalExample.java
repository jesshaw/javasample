package sample.concurrent;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by mzxiao on 2020/7/23 11:18
 */
public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> threadLocalFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(example, " " + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default threadLocal Formatter = " + threadLocalFormatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //threadLocalFormatter pattern is changed here by thread, but it won't reflect to other threads
        threadLocalFormatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " threadLocal Formatter = " + threadLocalFormatter.get().toPattern());
    }
}
