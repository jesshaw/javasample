package com.lexiangmiao.sample.transaction.springcloud.seata.orderserver.service;

import com.lexiangmiao.sample.transaction.springcloud.seata.orderserver.entity.Order;

import java.math.BigDecimal;

public interface OrderService {
    void create(Order order);

    void update(Long userId, BigDecimal money, Integer status);
}
