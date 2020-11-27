package com.lexiangmiao.sample.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringFrameworkApplication {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
//        app.register(SingtonPrototypeConfig.class);
//        app.refresh();
//
//        app.close();

        SpringApplication.run(SpringFrameworkApplication.class, args);
    }
}
