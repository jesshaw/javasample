package com.lexiangmiao.sample.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZookeeperApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZookeeperApp.class, args);
    }
}
