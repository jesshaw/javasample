package com.lexiangmiao.sample.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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

    @Autowired
    private RedissonClient redisson;

    @RequestMapping("submitOrder")
    public String submitOrder() {
        /*
        互斥性
        超时 解决断电或kill
        支持阻塞非阻塞
        */

        RLock rLock = redisson.getLock(product);
        rLock.lock(); //续命有默认值  阻塞
//        rLock.tryLock(); 非阻塞

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
            rLock.unlock();
        }
        return "end";
    }
}
