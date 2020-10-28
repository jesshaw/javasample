package com.lexiangmiao.sample.concurrent.oom;

/**
 * -Xms10m -Xmx10m
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[20 * 1024 * 1024];
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }

}
