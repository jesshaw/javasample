package com.lexiangmiao.sample.springcloud.alibaba.service;

import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-payment-nacos", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSql/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
