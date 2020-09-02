package com.lexiangmiao.sample.dubbospringboot.provider.service;

import com.lexiangmiao.sample.dubbospringboot.consumer.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


@DubboService(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {
    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("%s: Hello, %s. This time is %s", serviceName, name, new Date());
    }
}
