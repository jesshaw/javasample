package com.lexiangmiao.sample.concurrent.volatilekey;

/**
 * getInstance 加synchronized能解决，太重
 */
public class SingletonApp {
    private  static SingletonApp instance;

    private SingletonApp() {
        System.out.println("SingletonApp构造方法");
    }

    public static  SingletonApp getInstance() {
        if (instance == null) {
            synchronized (SingletonApp.class) {
                if (instance == null) {
                    instance = new SingletonApp();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());
//        System.out.println(SingletonApp.getInstance()==SingletonApp.getInstance());

        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                SingletonApp.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
