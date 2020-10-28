package com.lexiangmiao.sample.concurrent.gc;

import java.util.Random;

/**
 * 1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC    (DefNew+Tenured)
 *
 * 2
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC    (ParNew+Tenured)
 *
 * ParNew+Tenured这样的搭配，Java8已经不再推荐
 * Java HotSpot(TM)64-Bit Server VM Warning:
 * Using the ParNew young collector with the Serial old collection is deprecated and will likely be removed in a future release
 *
 * 3
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC    (PSYoungGen+ParOldGen)
 *
 * 4
 * 4.1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC    (PSYoungGen+ParOldGen)
 * 4.2 不加就是默认UseParallelGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags    (PSYoungGen+ParOldGen)
 *
 * 5
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC    (par new generation+ concurrent mark sweep)
 *
 * 6
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * 7 (理论知道即可，实际中java8已经被优化掉了)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 *
 * 一般生产不这么配置，仅学习用
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -xx:+UseParallelOldGC    (PSYoungGen+ParOldGen)
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC    (par new generation+ concurrent mark sweep)
 *
 *
 */
public class GCDemo {
    public static void main(String[] args) {

        System.out.println("*********GCDemo Hello");

        try {
            String str = "lexiangmiao";
            while (true) {
                str += str + new Random().nextInt(1000000000);
                str.intern();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
