package com.lexiangmiao.sample.concurrent.volatilekey;

/**
 * 有序性
 * <p>
 * 多线程环境method1可能会指令重排，导致method2在调用时不一定输出的值是6。
 */
public class Ordered {

    int a = 0;
    boolean flag = false;

    public void method1() {
        //以下两条语句因为没有依赖性，在多线程环境下可能会指令重排
        a = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 5;
            System.out.println("the a value:" + a);
        }
    }


}
