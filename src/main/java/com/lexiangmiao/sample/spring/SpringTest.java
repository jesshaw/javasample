package com.lexiangmiao.sample.spring;

import com.lexiangmiao.sample.mybatis.repository.cee.SchoolInfoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
