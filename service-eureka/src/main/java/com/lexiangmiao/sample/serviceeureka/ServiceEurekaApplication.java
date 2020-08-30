package com.lexiangmiao.sample.serviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//这是因为spring boot默认会加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration类，
// DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean。
// 因为工程中没有关于dataSource相关的配置信息，当spring创建dataSource bean因缺少相关的信息就会报错。
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ServiceEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEurekaApplication.class, args);
    }
}
