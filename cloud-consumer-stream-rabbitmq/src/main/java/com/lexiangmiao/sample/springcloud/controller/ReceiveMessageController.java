package com.lexiangmiao.sample.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        log.info("********消费者1号接收到的消息：" + message.getPayload() + "\t port: " + serverPort);
    }
}
