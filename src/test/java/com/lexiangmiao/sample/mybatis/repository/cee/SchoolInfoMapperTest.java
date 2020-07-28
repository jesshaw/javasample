package com.lexiangmiao.sample.mybatis.repository.cee;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfo;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mzxiao on 2020/7/28 15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolInfoMapperTest {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;
    @Test
    public void selectByExample() throws Exception {
        SchoolInfoExample example = new SchoolInfoExample();
//        example.createCriteria().andSchoolIdEqualTo(schoolId);
        List<SchoolInfo> students = schoolInfoMapper.selectByExample(example);
        assertTrue(students!=null&&students.size()>0);

    }

}