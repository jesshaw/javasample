package com.lexiangmiao.sample.concurrent.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    public static void softRefMemoryEnough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o = null;
        System.gc();
        System.out.println(o);
        System.out.println(softReference.get());
    }

    /**
     *
     *
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRefMemoryNotEnough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o = null;
        try {
            byte[] bytes = new byte[30*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }

    }

    public static void main(String[] args) {
        softRefMemoryEnough();
        softRefMemoryNotEnough();
    }
}
