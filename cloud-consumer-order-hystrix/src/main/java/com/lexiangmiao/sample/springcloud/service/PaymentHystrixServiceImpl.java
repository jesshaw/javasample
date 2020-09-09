package com.lexiangmiao.sample.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "********PaymentHystrixServiceImpl fall back paymentInfoOK";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "********PaymentHystrixServiceImpl fall back paymentInfoTimeout";
    }
}
