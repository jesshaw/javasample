package com.lexiangmiao.sample.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mzxiao on 2020/8/21 10:31
 */
@SpringBootApplication
public class TransactionSampleApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TransactionSampleApp.class, args);
    }

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void run(String... strings) throws Exception {
        Account byId = accountMapper.findById(2);

        System.out.println(byId);
    }
}
