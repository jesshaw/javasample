package com.lexiangmiao.sample.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope // 支持nacos的动态刷新
public class ConfigClientController {
    @Value("${server.port}")
    String serverPort;

    @Value("${config.info}")
    String configInfo;


    @GetMapping("/config/info")
    public String getConfigInfo() {
        return "server port:" + serverPort + "\n config info: " + configInfo;
    }
}
