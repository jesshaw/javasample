package com.lexiangmiao.sample.svc;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by mzxiao on 2020/7/29 17:32
 */
@Service
public class SchoolRedisSvc {

    private final RedisTemplate<String, String> redisTemplate;

    public SchoolRedisSvc(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 从学校的redis中获取所有学校id
     *
     * @throws Exception
     */
    public String[] fetchAllSchoolIds() {
        String allSchoolIdsStr = redisTemplate.opsForValue().get(RedisKey.School.allSchoolIds);
        return allSchoolIdsStr.split(RedisKey.splitStr);
    }
}
