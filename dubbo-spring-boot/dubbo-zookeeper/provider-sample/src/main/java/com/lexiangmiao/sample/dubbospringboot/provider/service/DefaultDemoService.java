package com.lexiangmiao.sample.dubbospringboot.provider.service;

import com.lexiangmiao.sample.dubbospringboot.consumer.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


@DubboService(version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {
    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public String sayHello(String name) {
        logger.info(String.format("%s: say hello by %s", serviceName, name));
        return String.format("%s: Hello, %s. This time is %s", serviceName, name, new Date());
    }
}
