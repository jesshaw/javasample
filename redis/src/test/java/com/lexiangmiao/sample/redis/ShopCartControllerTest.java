package com.lexiangmiao.sample.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static com.lexiangmiao.sample.redis.ShopCartController.stockKehy;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class ShopCartControllerTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void initStock() {
        stringRedisTemplate.opsForValue().set(stockKehy,"100");
    }

    @Test
    public void getStock() {
        System.out.println(stringRedisTemplate.opsForValue().get(stockKehy));
    }
}
