package com.lexiangmiao.sample.springcloud.controller;

import com.lexiangmiao.sample.springcloud.entities.CommonResult;
import com.lexiangmiao.sample.springcloud.entities.Payment;
import com.lexiangmiao.sample.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //负载均衡
    @Resource
    RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    LoadBalancer loadBalancer;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {

        log.info("*****插入结果" + payment);

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLb() {

//        // 须屏蔽config中的LoadBalanced
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        if (CollectionUtils.isEmpty(instances)) {
//            return null;
//        }
//
//        ServiceInstance instance = loadBalancer.instance(instances);
//        return restTemplate.getForObject(instance.getUri()+ "/payment/lb", String.class);
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/lb", String.class);
    }
}
