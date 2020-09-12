package com.lexiangmiao.sample.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class DockerDeployApp {
    public static void main(String[] args) {
        SpringApplication.run(DockerDeployApp.class, args);
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hi, the time is " + new Date();
    }
}
