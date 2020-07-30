package com.lexiangmiao.sample.svc;

import com.lexiangmiao.sample.Main;
import com.lexiangmiao.sample.cee.JacksonJsonUtil;
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
 * Created by mzxiao on 2020/7/30 9:15
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class SchoolSpecialtySvcTest {
    @Autowired
    SchoolSpecialtySvc schoolSpecialtySvc;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void fetchSchoolSpecialtySaveRedisBy() throws Exception {
        //    https://static-data.eol.cn/www/2.0/schoolspecialindex/年份/分校/湖南/文科/1.json
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json

        schoolSpecialtySvc.fetchSchoolSpecialtySaveRedisBy(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value(), 100);

        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value());
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void fetchTheYearSchoolSpecialtySaveRedisBy() throws Exception {
        schoolSpecialtySvc.fetchSchoolSpecialtySaveRedis("402");
        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2018.value(), "402", SubjectType.LIBERAL_ARTS.value());
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void generateKey() throws Exception {
        //schoolspecialindex/年份/分校/湖南/文科/1.json
        // schoolspecialindex/2019/402/43/2/1.json
        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value());

        Assert.assertEquals("schoolspecialindex/2019/402/43/2/1.json", redisKey);
    }

    @Test
    public void fetchAllSchoolSpecialtySaveRedis() throws Exception {
        schoolSpecialtySvc.fetchAllSchoolSpecialtySaveRedis();
    }


    @Test
    public void syncToDBBySchoolId() throws Exception {
        String schoolId = "402"; //湖南中医药大学
        schoolSpecialtySvc.syncToDBBySchoolId(schoolId);
    }

//
//    @Test
//    public void jsonDe() throws Exception {
//        JacksonJsonUtil.parseArray()
//    }

    @Test
    public void syncToDB() throws Exception {
        schoolSpecialtySvc.syncToDB();
    }

}