package com.lexiangmiao.sample.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class FlowLimitController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/testA")
    public String testA() {

        /**执行方法的时间，用于看线程阀值效果**/
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        log.info(Thread.currentThread().getName()+"\t test A");

        return "*********testA time: " + new Date();
    }

    @GetMapping("/testB")
    public String testB() {

        log.info("****tetB"+new Date());
        return "*********testB time: " + new Date();
    }

    @GetMapping("/testD")
    public String downgrade() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int a = 10 / 0;
        return "*********testB time: " + new Date();
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
//        int a = 10 / 0;
        return "*********testHotKey time: " + new Date();
    }

    public String dealTestHotKey(String p1, String p2, BlockException block) {
        return "*********dealTestHotKey.";
    }
}
