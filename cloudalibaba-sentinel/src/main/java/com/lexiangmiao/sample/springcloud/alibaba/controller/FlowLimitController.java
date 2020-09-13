package com.lexiangmiao.sample.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/testA")
    public String testA() {

        return "*********testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "*********testB";
    }
}
