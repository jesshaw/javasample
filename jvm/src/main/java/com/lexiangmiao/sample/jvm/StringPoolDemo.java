package com.lexiangmiao.sample.jvm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 当调用intern方法时，如果池已经包含与equals(Object)方法确定的相当于此String对象的字符串，则返回来自池的字符串。 否则，此String对象将添加到池中，并返回对此String对象的引用。
 *
 * jdk在加载时，会加载sun.misc.Version为静态变量的java到字符串常量池。jdk加载在main加载之前，所以此时最后一行为false。
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String st1 = new StringBuilder("lexiang").append("miao").toString();
        System.out.println(st1);
        System.out.println(st1.intern());
        System.out.println(st1 == st1.intern());

        String st2 = new StringBuilder("ja").append("va").toString();
        System.out.println(st2);
        System.out.println(st2.intern());
        System.out.println(st1 == st2.intern());
    }

}
