package com.lexiangmiao.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopCartController {
    public static final String product = "123456789";
    public static final String stockKehy = "stock";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("submitOrder")
    public String submitOrder() {
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(product, "ant");
        if (!lock) {
            return "error";
        }
        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(stockKehy));
        if (stock > 0) {
            stock = stock - 1;
            stringRedisTemplate.opsForValue().set(stockKehy, stock + "");
            System.out.println("扣减成功，库存：" + stock);
        } else {
            System.out.println("扣减失败，库存不足");
        }
        stringRedisTemplate.delete(product);
        return "end";
    }
}
