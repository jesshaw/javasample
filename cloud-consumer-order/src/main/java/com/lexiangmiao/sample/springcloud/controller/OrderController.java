package com.lexiangmiao.sample.springcloud.controller;

import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //负载均衡
    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create( Payment payment) {

        log.info("*****插入结果"+payment);

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }
}
