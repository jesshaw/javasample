package com.lexiangmiao.sample.java.core;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());

        }, "ss").start();
    }
}
