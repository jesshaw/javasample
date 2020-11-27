package com.lexiangmiao.sample.springframework.circulardependency;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    private ServiceA serviceA;

//    public ServiceB(ServiceA serviceA) {
//        this.serviceA = serviceA;
//    }
}
