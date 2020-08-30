package com.lexiangmiao.sample.serviceorder.controller;

import com.lexiangmiao.sample.serviceorder.dto.Order;
import com.lexiangmiao.sample.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getById/{id}")
    public Order getById(@PathVariable("id") Integer id) {
        Order order = orderService.getById(id);
        return order;
    }

    @RequestMapping("/findOrderByUserId/{userId}")
    public List<Order> findOrdersByUserId(@PathVariable("userId") Integer userId) {
        List<Order> orders = orderService.findOrdersByUserId(userId);
        return orders;
    }
}
