package com.lexiangmiao.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ShopCartController {
    public static final String product = "123456789";
    public static final String stockKehy = "stock";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("submitOrder")
    public String submitOrder() {
        /*
        互斥性
        超时 解决断电或kill
        支持阻塞非阻塞
        */

        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(product,"ant",30,TimeUnit.SECONDS);
        if (!lock) {
            return "error";
        }
        try {
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(stockKehy));
            if (stock > 0) {
                stock = stock - 1;
                stringRedisTemplate.opsForValue().set(stockKehy, stock + "");
                System.out.println("扣减成功，库存：" + stock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            stringRedisTemplate.delete(product);
        }
        return "end";
    }
}
