package com.lexiangmiao.sample.dubbospringboot.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DubboRegistryZookeeperConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(version = "${demo.service.version}")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboRegistryZookeeperConsumerApplication.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            IntStream.range(0, 50).forEach(i -> {
                logger.info(demoService.sayHello("jes"));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };
    }

}
