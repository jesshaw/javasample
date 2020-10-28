package com.lexiangmiao.sample.concurrent.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHasMapDemo {
    public static void main(String[] args) {

        myHashMap();

        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }
}
