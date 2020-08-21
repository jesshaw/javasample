package com.lexiangmiao.sample.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by mzxiao on 2020/8/21 17:21
 */
@Service
public class AccountSvcImpl implements AccountSvc {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void transfer(String out, String in, BigDecimal amount) throws Exception {
        outMoney(out, amount);
        inMoney(in, amount);
    }

    @Override
    public void outMoney(String out, BigDecimal amount) throws Exception {
        Account account = accountMapper.findByName(out);
        BigDecimal preBalance = account.getBalance().subtract(amount);
        if (preBalance.doubleValue() > 0) {
            accountMapper.update(out, preBalance);
        }
        else {
            throw new Exception("余额不足，转账失败");
        }
    }

    @Override
    public void inMoney(String in, BigDecimal amount) throws Exception {
        Account account = accountMapper.findByName(in);
        BigDecimal preBalance = account.getBalance().add(amount);
        accountMapper.update(in, preBalance);
    }
}
