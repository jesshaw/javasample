package sample.svc;

import com.lexiangmiao.sample.Main;
import com.lexiangmiao.sample.svc.ProvincialScoreSvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mzxiao on 2020/7/29 10:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ProvincialScoreSvcTest {
    @Test
    public void syncToDB() throws Exception {
        provincialScoreSvc.syncToDB();
    }

    @Autowired
    ProvincialScoreSvc provincialScoreSvc;
    @Test
    public void syncToDBBySchoolId() throws Exception {

        String schoolId = "402"; //湖南中医药大学
        provincialScoreSvc.syncToDBBySchoolId(schoolId);
    }

}