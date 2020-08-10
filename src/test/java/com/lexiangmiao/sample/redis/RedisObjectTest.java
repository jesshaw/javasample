package com.lexiangmiao.sample.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lexiangmiao.sample.svc.dto.JobDTO;
import com.lexiangmiao.sample.svc.dto.JobDefinitionDTO;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Date;
import java.util.Map;

/**
 * Created by mzxiao on 2020/7/31 17:13
 */
public class RedisObjectTest {
    @Test
    public void redistHashTest() throws Exception {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("localhost");
        connectionFactory.setPort(16379);
        connectionFactory.setPassword("");

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        JobDTO job = new JobDTO();
        job.setId("1");
        job.setCreateTime(new Date());
        job.setSubmitterName("Jon Snow");
        job.setJobDef(new JobDefinitionDTO(){{setDef("nightwatch");}});

        ObjectMapper objectMapper = new ObjectMapper();
        Map jobHash= objectMapper.convertValue(job, Map.class);
        redisTemplate.opsForHash().putAll("job:" + job.getId(), jobHash);

        Map jobMap = redisTemplate.opsForHash().entries("job:" + job.getId());

    }
}
