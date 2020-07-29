package com.lexiangmiao.sample.svc;

import com.lexiangmiao.sample.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mzxiao on 2020/7/29 8:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class SchoolSvcTest {
    @Autowired
    SchoolSvc schoolSvc;

    @Test
    public void fetchSchoolSaveRedis() throws Exception {
    }

    @Test
    public void fetchAllSchoolIdSavRedis() throws Exception {
    }

    @Test
    public void fetchAllSchoolIds() throws Exception {
    }

    @Test
    public void syncToDBBySchoolId() throws Exception {
        String schoolId = "402"; //湖南中医药大学
        schoolSvc.syncToDBBySchoolId(schoolId);
    }

    @Test
    public void syncToDB() throws Exception {
        schoolSvc.syncToDB();
    }

}