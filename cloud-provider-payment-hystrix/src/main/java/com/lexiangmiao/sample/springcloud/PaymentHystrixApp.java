package com.lexiangmiao.sample.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApp.class, args);
    }
}
