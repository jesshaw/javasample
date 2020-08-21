package com.lexiangmiao.sample.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mzxiao on 2020/8/21 13:56
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.MANDATORY )
public class AccountSvc {
}
