package com.lexiangmiao.sample.concurrent;

/**
 * Created by mzxiao on 2020/7/23 11:05
 *
 * javac -encoding UTF-8 SynchronizedCodeSnippet.java
 *
 * javap -c -s -v -l SynchronizedCodeSnippet.class
 *
 */
public class SynchronizedCodeSnippet {
    public void method(){
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
