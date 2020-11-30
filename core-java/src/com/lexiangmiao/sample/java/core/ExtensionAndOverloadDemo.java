package com.lexiangmiao.sample.java.core;

/**
 * 重载方法按声明调用
 * 实例方法按实例对应实例化调用
 */
public class ExtensionAndOverloadDemo {
    public static void main(String[] args) {
        Father f = new Son();
        print(f);

        printInt(Integer.valueOf(1));
        printInt(1);
    }

    static void print(Father o) {
        System.out.println("static father method print");
        o.print();
    }

    static void print(Son o) {
        System.out.println("static son method print");
        o.print();
    }

    static void printInt(Integer i) {
        System.out.println("Integer print " + i);
    }

    static void printInt(int i) {
        System.out.println("int print " + i);
    }
}

class Father {
    public void print() {
        System.out.println("Father print");
    }
}

class Son extends Father {
    public void print() {
        System.out.println("Son print");
        try {
        } finally {

        }
    }
}
