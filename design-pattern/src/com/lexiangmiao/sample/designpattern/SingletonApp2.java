package com.lexiangmiao.sample.designpattern;

import java.util.Arrays;
import java.util.Date;

/**
 * java类中的静态代码块相当与c#中的静态构造器
 *
 * 类中的内部静态类并不会立即加载，会到真正调用时加载，所以这一特性解决了多线程下的安全问题（即不会实例化多个实例）。
 */
public class SingletonApp2 {

    static  {
        System.out.println("SingletonApp2 static:"+new Date().getTime());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----");
    }

    private static SingletonApp2 instance;

    private SingletonApp2() {
        System.out.println("SingletonApp2:"+new Date().getTime());
        System.out.println("SingletonApp2构造方法");
    }


    static class SingleHolder {
        static  {
            System.out.println("SingleHolder:"+new Date().getTime());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----");
        }
        public static final SingletonApp2 instance = new SingletonApp2();
    }

    public static SingletonApp2 getInstance() {
        return SingleHolder.instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());


        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
//                SingletonApp2 s2=SingletonApp2.getInstance();
//                SingletonApp2 s=  SingleHolder.instance;
            }, String.valueOf(i)).start();
        }
    }
}
