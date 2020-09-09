package com.lexiangmiao.sample.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
