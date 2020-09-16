package com.lexiangmiao.sample.springcloud.alibaba.service;

import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        Payment payment = new Payment(id, "erro serial");
        return new CommonResult<>(44444, "服务降级返回，PaymentFallbackServiceImpl ", payment);

    }
}
