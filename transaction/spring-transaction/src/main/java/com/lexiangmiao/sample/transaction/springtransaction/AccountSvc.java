package com.lexiangmiao.sample.transaction;

import java.math.BigDecimal;

/**
 * Created by mzxiao on 2020/8/21 13:56
 */
public interface AccountSvc {
    void transfer(String out, String in, BigDecimal amount) throws Exception;

    void outMoney(String out, BigDecimal amount) throws Exception;

    void inMoney(String in, BigDecimal amount) throws Exception;
}
