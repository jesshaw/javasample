package com.lexiangmiao.sample.springcloud.alibaba.controller;

import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        return "nacos registry, server port: " + serverPort + "\t id: " + id;
    }

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "18abc81"));
        hashMap.put(2L, new Payment(2L, "28abc82"));
        hashMap.put(3L, new Payment(3L, "38abc83"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> getPaymentSql(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql, server port: " + serverPort, payment);
        return result;
    }



}
