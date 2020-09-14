package com.lexiangmiao.sample.container;


import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 1. WeekHashMap中默认存储的是弱引用键值条目（entry）,HashMap默认存储的是强引用entry
 * 2. 当key丢弃时，WeekHashMap中对应的entry会被垃圾回收（GC），但HashMap不会。
 * 3. WeekHashMap未实现Cloneable接口，仅实现了Map接口。
 */

public final class WeakHasMapVsHasMap {
    public static void main(String[] args) throws InterruptedException {
        Map weakHashMap = new WeakHashMap();
        Demo d = new Demo();
        weakHashMap.put(d, " Hi ");
        System.out.println(weakHashMap);
        d = null;
        System.gc();
        Thread.sleep(2000);
        System.out.println(weakHashMap);


        System.out.println("******************");

        Map hashMap = new HashMap();
        Demo d1 = new Demo();
        hashMap.put(d1, " Hi ");
        System.out.println(hashMap);
        d1 = null;
        System.gc();
        Thread.sleep(2000);
        System.out.println(hashMap);
    }
}


class Demo {
    public String toString() {
        return "demo";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("析构方法被调用");
    }
}
