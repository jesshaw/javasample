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

        String redisKey = schoolPlanSvc.generateKey(Year.YEAR_2020.value(), "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value(),1);

        Assert.assertEquals("schoolplanindex/2020/402/43/2/7/1.json", redisKey);
    }

    @Test
    public void fetchAllSchoolPlanSaveRedis() throws Exception {
        schoolPlanSvc.fetchAllSchoolPlanSaveRedis();
    }
    @Test
    public void test() throws Exception {
//                -- 年份      参考人数    文科  反推位数
//                -- 2017      410800      152900  12770
//                -- 2018      451800      168700  13175
//                -- 2019      499000      185000  14448
//                -- 2020      536000      194000  15151
//        1.51/19.4=x/18.5
        System.out.println(15151/194000.00*185000);
        System.out.println(15151/194000.00*168700);
        System.out.println(15151/194000.00*152900);

        System.out.println(15151/53.6*49.9);
        System.out.println(15151/53.6*45.18);
    }

    @Test
    public void fetchSchoolPlanSaveRedisBy() throws Exception {
        // https://static-data.eol.cn/www/2.0/schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // https://static-data.eol.cn/www/2.0/schoolplanindex/2020/402/43/2/7/1.json
        schoolPlanSvc.fetchSchoolPlanSaveRedisBy(Year.YEAR_2020.value(), "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value(), 100);
        String redisKey = schoolPlanSvc.generateKey(Year.YEAR_2020.value(), "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value(),1);
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void fetchSchoolPlanSaveRedis() throws Exception {
        // https://static-data.eol.cn/www/2.0/schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // https://static-data.eol.cn/www/2.0/schoolplanindex/2020/402/43/2/7/1.json
        schoolPlanSvc.fetchSchoolPlanSaveRedis("402");
        String redisKey = schoolPlanSvc.generateKey(Year.YEAR_2020.value(), "402", SubjectType.LIBERAL_ARTS.value(), AdmissionBatch.Undergraduate_First_Batch.value(),3);
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void syncToDBBySchoolId() throws Exception {
        String schoolId = "402"; //湖南中医药大学
        schoolPlanSvc.syncToDBBySchoolId(schoolId);
    }

    @Test
    public void syncToDB() throws Exception {
        schoolPlanSvc.syncToDB();
    }

}