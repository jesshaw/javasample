package com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.service;

import com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.dao.InventoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    public static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->扣减库存开始");
        inventoryDao.decrease(productId, count);
        LOGGER.info("------->扣减库存结束");
    }
}
