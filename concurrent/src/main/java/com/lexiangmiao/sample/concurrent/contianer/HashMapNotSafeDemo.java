package com.lexiangmiao.sample.concurrent.contianer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashMapNotSafeDemo {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
//        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
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
         *   3.1 Collections.synchronizedMap(new HashMap<>());
         *   3.2 new ConcurrentHashMap<>();
         *
         *
         * 4 优化建议
         */
    }
}
