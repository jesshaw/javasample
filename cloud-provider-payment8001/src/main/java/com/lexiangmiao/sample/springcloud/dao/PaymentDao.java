package com.lexiangmiao.sample.springcloud.dao;

import com.lexiangmiao.sample.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") long id);
}
