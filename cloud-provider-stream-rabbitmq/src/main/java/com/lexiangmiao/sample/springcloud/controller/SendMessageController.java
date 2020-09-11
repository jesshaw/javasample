package com.lexiangmiao.sample.springcloud.controller;

import com.lexiangmiao.sample.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProvider.send();
    }
}
