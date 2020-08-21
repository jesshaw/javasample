package com.lexiangmiao.sample.concurrent;

/**
 * Created by mzxiao on 2020/7/23 11:13
 *
 * javac -encoding UTF-8 SynchronizedMethod.java
 *
 * javap -c -s -v -l SynchronizedMethod.class
 *
 */
public class SynchronizedMethod {
    public synchronized void method(){
        System.out.println("synchronized 方法");
    }
}
