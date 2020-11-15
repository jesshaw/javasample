package com.lexiangmiao.sample.container.list;

import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        int oldCapacity = 2;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        System.out.println("oldCapacity = " + oldCapacity);
        System.out.println("newCapacity = " + newCapacity);
    }
}
