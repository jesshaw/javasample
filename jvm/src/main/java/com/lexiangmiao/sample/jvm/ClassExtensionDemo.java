package com.lexiangmiao.sample.jvm;

/**
 * 重载方法按声明调用
 * 实例方法按实例对应实例化调用
 */
public class ClassExtensionDemo {
    public static void main(String[] args) {
        Father f = new Son();
        print(f);
    }
    static void print(Father o) {
        System.out.println("static father method print");
        o.print();
    }
    static void print(Son o) {
        System.out.println("static son method print");
        o.print();
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
        try{}
        finally {

        }
    }
}
