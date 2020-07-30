package com.lexiangmiao.sample.svc;

import com.lexiangmiao.sample.svc.dto.AdmissionBatch;
import com.lexiangmiao.sample.svc.dto.SubjectType;
import com.lexiangmiao.sample.svc.dto.Year;
import com.lexiangmiao.sample.util.RestTemplateProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by mzxiao on 2020/7/29 17:26
 */
@Service
public class SchoolPlanSvc {

    private final RedisTemplate<String, String> redisTemplate;
    private final SchoolRedisSvc schoolRedisSvc;

    public SchoolPlanSvc(RedisTemplate<String, String> redisTemplate, SchoolRedisSvc schoolRedisSvc) {
        this.redisTemplate = redisTemplate;
        this.schoolRedisSvc = schoolRedisSvc;
    }

    public void fetchAllSchoolPlanSaveRedis() throws Exception {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            for (Integer year : Year.getAllValues()) {
                for (Integer batch : AdmissionBatch.getAllValues()) {
                    fetchSchoolPlanSaveRedisBy(year, schoolId, SubjectType.LIBERAL_ARTS.value(),batch, 200);
                }
            }
        }
    }

    public String generateKey(Integer year, String schoolId, Integer subjectType,Integer batch) {
       return String.format(RedisKey.SchoolPlan.pre, year, schoolId, subjectType,batch);
    }
    /**
     *
     * @param year 年份
     * @param schoolId
     * @param subjectType 文理科类型
     * @param sleepMilliseconds
     * @throws InterruptedException
     */
    public void fetchSchoolPlanSaveRedisBy(Integer year, String schoolId, Integer subjectType,Integer batch, int sleepMilliseconds) throws InterruptedException {
        // https://static-data.eol.cn/www/2.0/schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // https://static-data.eol.cn/www/2.0/schoolplanindex/2020/402/43/2/7/1.json
        String key = generateKey(year, schoolId, subjectType, batch);
        String url = String.format("https://static-data.eol.cn/www/2.0/%s", key);
        String result = RestTemplateProxy.fetch(url);
        System.out.println(url);
        redisTemplate.opsForValue().set(String.format(RedisKey.SchoolPlan.pre, key), result, RedisKey.oneYear, TimeUnit.SECONDS);
        Thread.sleep(sleepMilliseconds);
    }
}
