package com.lexiangmiao.sample.concurrent.contianer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetNotSafeDemo {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }

        // java.util.ConcurrentModificationException

        /**
         * 1 故障现象
         *   java.util.ConcurrentModificationException
         *
         * 2 导致原因
         *
         * 3 解决方案
         *   3.1 Collections.synchronizedList(new HashSet<>());
         *   3.2 new CopyOnWriteArraySet<>();
         *
         *
         * 4 优化建议
         */
    }
}
