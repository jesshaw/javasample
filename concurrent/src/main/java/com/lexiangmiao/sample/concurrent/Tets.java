package com.lexiangmiao.sample.concurrent;

public class Tets {
    public static void main(String[] args) {
        Integer a = 10;
        a(a);
        System.out.println(a);
    }

    public static void a(Integer a) {
        a++;
    }
}
