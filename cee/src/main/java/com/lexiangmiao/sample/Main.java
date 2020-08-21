package com.lexiangmiao.sample;

import com.lexiangmiao.sample.mybatis.repository.cee.SchoolInfoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mzxiao on 2020/7/28 15:46
 */
@SpringBootApplication
@MapperScan(basePackageClasses = SchoolInfoMapper.class)  // 加了这句才能自动装配mybatis dao
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
