package com.lexiangmiao.sample.concurrent.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o,referenceQueue);
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        o = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }

}
