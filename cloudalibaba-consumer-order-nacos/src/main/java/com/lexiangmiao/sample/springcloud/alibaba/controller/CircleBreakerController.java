package com.lexiangmiao.sample.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lexiangmiao.sample.springcloud.alibaba.service.PaymentService;
import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${server.port}")
    String serverPort;
    @Value("${service-url.nacos-payment-servcie}")
    String paymentUrl;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallBack")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandlerFallBack")
//    @SentinelResource(value = "fallback",fallback = "handlerFallBack",blockHandler = "blockHandlerFallBack")
    @SentinelResource(value = "fallback",fallback = "handlerFallBack",blockHandler = "blockHandlerFallBack",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallBAck(@PathVariable Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(paymentUrl + "/paymentSql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常....");

        }

        return result;
    }
    public CommonResult<Payment> handlerFallBack(Long id,Throwable e) {
        Payment payment = new Payment(id, "null");

        return new CommonResult<>(444, "兜底异常handerFallBack，exception: " + e.getMessage(), payment);
    }
    public CommonResult<Payment> blockHandlerFallBack(Long id, BlockException block) {
        Payment payment = new Payment(id, "null");

        return new CommonResult<>(444, "sentinel限流，blockHandlerFallBack，无此流水，block exception: " + block.getMessage(), payment);
    }

    @Resource
    PaymentService paymentService;


    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }
}
