package com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver;

import com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.dao.InventoryDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackageClasses = InventoryDao.class)
//@EnableDiscoveryClient //可以不加，自动发现
public class InventoryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServerApplication.class, args);
    }
}
