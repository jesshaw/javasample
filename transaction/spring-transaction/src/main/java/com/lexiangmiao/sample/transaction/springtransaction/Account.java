package com.lexiangmiao.sample.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mzxiao on 2020/8/21 10:52
 * ref: https://mybatis.org/mybatis-3/java-api.html
 */
public class Account implements Serializable {
    private Long id;
    private String name;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
