package com.lexiangmiao.sample.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mzxiao on 2020/7/28 15:46
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.lexiangmiao.sample.spring");
        ctx.refresh();
        Object userServcie = ctx.getBean("userService");

    }
}
