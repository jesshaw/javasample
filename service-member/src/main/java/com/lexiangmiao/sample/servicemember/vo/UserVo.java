package com.lexiangmiao.sample.servicemember.vo;

import com.lexiangmiao.sample.servicemember.Order;

import java.util.List;

public class UserVo {
    private List<Order> orderList;
    private String userName;

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
