package com.lexiangmiao.sample.svc;

import com.lexiangmiao.sample.Main;
import com.lexiangmiao.sample.svc.dto.AdmissionBatch;
import com.lexiangmiao.sample.svc.dto.SubjectType;
import com.lexiangmiao.sample.svc.dto.Year;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mzxiao on 2020/7/30 9:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class SchoolPlanSvcTest {
    @Autowired
    SchoolPlanSvc schoolPlanSvc;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void generateKey() throws Exception {
        // schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // schoolplanindex/2020/402/43/2/7/1.json

        String redisKey = schoolPlanSvc.generateKey(Year.YEAR_2020.value(), "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value());

        Assert.assertEquals("schoolplanindex/2020/402/43/2/7/1.json", redisKey);
    }

    @Test
    public void fetchAllSchoolPlanSaveRedis() throws Exception {
        schoolPlanSvc.fetchAllSchoolPlanSaveRedis();
    }

    @Test
    public void fetchSchoolPlanSaveRedisBy() throws Exception {
        // https://static-data.eol.cn/www/2.0/schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // https://static-data.eol.cn/www/2.0/schoolplanindex/2020/402/43/2/7/1.json
        schoolPlanSvc.fetchSchoolPlanSaveRedisBy(2020, "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value(), 100);

//            String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
//            System.out.println(allSchoolIdsStr);
//            System.out.println(redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 386)));
//            System.out.println("");
//            System.out.println(redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 3554)));
//
//            String s = redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 3554));
//            Assert.assertTrue(s.equals("\"\""));
    }

}