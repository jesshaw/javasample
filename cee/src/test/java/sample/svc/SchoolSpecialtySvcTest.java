package sample.svc;

import com.lexiangmiao.sample.Main;
import com.lexiangmiao.sample.svc.SchoolSpecialtySvc;
import com.lexiangmiao.sample.svc.dto.SubjectType;
import com.lexiangmiao.sample.svc.dto.Year;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mzxiao on 2020/7/30 9:15
 * 560
 * 14966
 * 含地方 15151
 * 2018年 45.18万 16.87
 * 2019年 49.9万 18.5
 * 2020年 536万 19.4 1.5151
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class SchoolSpecialtySvcTest {
    @Autowired
    SchoolSpecialtySvc schoolSpecialtySvc;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    List<String> schoolIds = Arrays.asList("512", "392", "406", "386", "396", "406", "396", "483", "185", "2463", "69", "396", "396", "386", "597", "398", "386", "263", "176", "361", "392", "402", "391", "504", "391", "459", "402", "392", "199", "74", "433", "314", "834", "44", "391", "622", "199", "402", "351", "1275", "520", "529", "421", "1474", "607", "402", "434", "184", "419", "459");

    @Test
    public void fetchSchoolSpecialtySaveRedisBy() throws Exception {
        //    https://static-data.eol.cn/www/2.0/schoolspecialindex/年份/分校/湖南/文科/1.json
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json

        schoolSpecialtySvc.fetchSchoolSpecialtySaveRedisBy(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value(), 100);

        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value(), 1);
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void fetchTheYearSchoolSpecialtySaveRedisBy() throws Exception {
        String schoolId = "402"; //湖南中医药大学
        schoolSpecialtySvc.fetchSchoolSpecialtySaveRedis(schoolId);
        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2018.value(), schoolId, SubjectType.LIBERAL_ARTS.value(), 1);
        String redisResult = redisTemplate.opsForValue().get(redisKey);
        System.out.println(redisResult);
    }

    @Test
    public void generateKey() throws Exception {
        //schoolspecialindex/年份/分校/湖南/文科/1.json
        // schoolspecialindex/2019/402/43/2/1.json
        String redisKey = schoolSpecialtySvc.generateKey(Year.YEAR_2019.value(), "402", SubjectType.LIBERAL_ARTS.value(), 1);

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