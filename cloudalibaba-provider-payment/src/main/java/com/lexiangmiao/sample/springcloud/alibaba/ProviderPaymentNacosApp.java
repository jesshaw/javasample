package com.lexiangmiao.sample.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentNacosApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentNacosApp.class, args);
    }
}
