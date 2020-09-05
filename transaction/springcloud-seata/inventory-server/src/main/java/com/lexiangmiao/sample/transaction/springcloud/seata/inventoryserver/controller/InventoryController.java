package com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.controller;

import com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryServiceImpl;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     数量
     * @return
     */
    @GetMapping("decrease")
    public String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        inventoryServiceImpl.decrease(productId, count);
        return "Decrease storage success";
    }
}
