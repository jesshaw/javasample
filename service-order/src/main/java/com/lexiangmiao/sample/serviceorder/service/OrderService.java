package com.lexiangmiao.sample.serviceorder.service;

import com.lexiangmiao.sample.serviceorder.dto.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    public Order getById(Integer id) {
        return generate();
    }

    public Order generate() {
        Order result = new Order();
        result.setId(1);
        result.setUserId(1);
        result.setAmount(500);
        return result;
    }

    public List<Order> findOrdersByUserId(Integer userId) {
        List<Order> results = new ArrayList<>();
        results.add(generate());
        return results;
    }
}
