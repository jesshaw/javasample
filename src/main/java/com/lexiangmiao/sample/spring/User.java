package com.lexiangmiao.sample.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by mzxiao on 2020/8/19 16:35
 */
@Component
public class User implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
