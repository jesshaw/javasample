package com.lexiangmiao.sample.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Value("${server.port}")
    String serverPort;
    @Value("${service-url.nacos-payment-servcie}")
    String paymentUrl;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        return restTemplate.getForObject(paymentUrl + "/payment/nacos/" + id, String.class);
    }
}
