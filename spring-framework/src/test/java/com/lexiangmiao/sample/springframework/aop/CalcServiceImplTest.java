package com.lexiangmiao.sample.springframework.aop;

import com.lexiangmiao.sample.springframework.SpringFrameworkApplication;
import com.lexiangmiao.sample.springframework.scope.ScopeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringFrameworkApplication.class)
public class CalcServiceImplTest {
    @Resource
    private CalcServiceImpl calcService;

    @Test
    public void div() {
        System.out.println("spring 版本：" + SpringVersion.getVersion() + "\t spring boot版本：" + SpringBootVersion.getVersion());

        System.out.println();
        calcService.div(10, 2);

        System.out.println();
        calcService.div(10, 0);
    }
}
