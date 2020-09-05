package com.lexiangmiao.sample.transaction.springcloud.seata.orderserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("inventory-server")
public interface InventoryApi {

    @GetMapping(value = "/inventory/decrease")
    String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
