package com.lexiangmiao.sample.springframework.circulardependency;

/**
 * 明显构造器方式，存在无限嵌套
 *
 * 通过设置方式注入是可以解决嵌套的
 *
 * spring是通过3级缓存来解决循环依赖的
 *   DefaultSingletonBeanRegistry
 *
 */
public class ClientTest {
    public static void main(String[] args) {
        // 明显构造器方式，存在无限嵌套
//        ServiceA serviceA = new ServiceA(new ServiceB(new ServiceA()));

        // 通过设置方式注入是可以解决嵌套的
//        ServiceA serviceA = new ServiceA();
//        ServiceB serviceB = new ServiceB();
//        serviceA.setServiceB(serviceB);
//        serviceB.setServiceA(serviceA);
    }
}
