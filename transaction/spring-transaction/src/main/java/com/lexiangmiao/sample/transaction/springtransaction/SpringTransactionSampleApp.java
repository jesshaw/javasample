package com.lexiangmiao.sample.transaction.springtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

/**
 * Created by mzxiao on 2020/8/21 10:31
 */
@SpringBootApplication
public class SpringTransactionSampleApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionSampleApp.class, args);
    }

    @Autowired
    private AccountSvc accountSvc;

    @Override
    public void run(String... strings) throws Exception {

        accountSvc.transfer("alice", "tom", new BigDecimal("200"));

    }
}
