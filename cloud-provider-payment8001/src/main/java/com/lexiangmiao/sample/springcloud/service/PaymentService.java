package com.lexiangmiao.sample.springcloud.service;

import com.lexiangmiao.sample.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(long id);
}
