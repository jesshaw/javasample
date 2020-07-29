package com.lexiangmiao.sample.svc;

import com.lexiangmiao.sample.util.RestTemplateProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by mzxiao on 2020/7/29 17:26
 */
@Service
public class SchoolSpecialtySvc {
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/年份/分校/湖南/文科/1.json
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json

    private final RedisTemplate<String, String> redisTemplate;
    private final SchoolRedisSvc schoolRedisSvc;

    public SchoolSpecialtySvc(RedisTemplate<String, String> redisTemplate, SchoolRedisSvc schoolRedisSvc) {
        this.redisTemplate = redisTemplate;
        this.schoolRedisSvc = schoolRedisSvc;
    }

    public void fetchAllProvicialScoresSaveRedis() throws Exception {
        for (String item : schoolRedisSvc.fetchAllSchoolIds()) {
            saveRedisBySchoolId(item, 500);
        }
    }

    public void saveRedisBySchoolId(String shcoolId, int sleepMilliseconds) throws InterruptedException {

//    https://static-data.eol.cn/www/2.0/schoolspecialindex/年份/分校/湖南/文科/1.json
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json
        String url = "https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json";
        String result = RestTemplateProxy.fetch(url);
//            System.out.println(url);
        redisTemplate.opsForValue().set(String.format(RedisKey.ProvincialScore.schoolPerYearScore, shcoolId), result, RedisKey.oneYear, TimeUnit.SECONDS);
        Thread.sleep(sleepMilliseconds);
    }
}
