package com.lexiangmiao.sample.concurrent.contianer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list1 = new LinkedList<>();
        Vector<String> v1;
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
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
         *   3.1 new Vector<>(); 方法加synchronized 能解决太重
         *   3.2 Collections.synchronizedList(new ArrayList<>());
         *   3.3 new CopyOnWriteArrayList<>();
         *
         *
         * 4 优化建议
         */
    }
}
