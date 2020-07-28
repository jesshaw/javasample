package com.lexiangmiao.sample.cee;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by mzxiao on 2020/7/27 10:18
 */
@TestConfiguration
public class BeanConfig {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//
//
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of("password"));
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("localhost");
        connectionFactory.setPort(16379);
        connectionFactory.setPassword("");
//        if(!StringUtils.isEmpty(password))
//            connectionFactory.setPassword(password);

        return connectionFactory;
    }

//    @Bean
//    public LettuceConnectionFactory redisLettuceConnectionFactory() {
//        return new LettuceConnectionFactory(
//                "localhost",
//                16379);
//    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory());
        // 设置redis的String/Value的默认序列化方式
        DefaultStrSerializer stringRedisSerializer = new DefaultStrSerializer();
        redis.setKeySerializer(stringRedisSerializer);
        redis.setValueSerializer(stringRedisSerializer);
        redis.setHashKeySerializer(stringRedisSerializer);
        redis.setHashValueSerializer(stringRedisSerializer);

        return redis;
    }

    @Bean
    public ExcelDownloadSvc excelDownloadSvc() {
       return new ExcelDownloadSvc();
    }
}
