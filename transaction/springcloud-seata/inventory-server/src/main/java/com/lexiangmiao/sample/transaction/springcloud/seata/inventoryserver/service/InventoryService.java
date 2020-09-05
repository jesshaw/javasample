package com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.service;

public interface InventoryService {

    void decrease(Long productId, Integer count);
}
