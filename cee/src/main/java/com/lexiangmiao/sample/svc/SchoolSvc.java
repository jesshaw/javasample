package com.lexiangmiao.sample.svc;

import com.fasterxml.jackson.databind.JsonNode;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfo;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfoExample;
import com.lexiangmiao.sample.mybatis.repository.cee.SchoolInfoMapper;
import com.lexiangmiao.sample.svc.dto.SchoolDTO;
import com.lexiangmiao.sample.svc.mapper.SchoolAdapter;
import com.lexiangmiao.sample.util.JacksonJsonUtil;
import com.lexiangmiao.sample.util.RestTemplateProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/29 8:53
 */
@Service
public class SchoolSvc {
    final int schoolSize = RedisKey.School.schoolQuatity;
    final int pageSize = 20;

    private final RedisTemplate<String, String> redisTemplate;
    private final SchoolInfoMapper schoolInfoMapper;
    private final SchoolAdapter schoolAdapter;
    private final SchoolRedisSvc schoolRedisSvc;

    public SchoolSvc(RedisTemplate<String, String> redisTemplate, SchoolInfoMapper schoolInfoMapper, SchoolAdapter schoolAdapter, SchoolRedisSvc schoolRedisSvc) {
        this.redisTemplate = redisTemplate;
        this.schoolInfoMapper = schoolInfoMapper;
        this.schoolAdapter = schoolAdapter;
        this.schoolRedisSvc = schoolRedisSvc;
    }

    /**
     * 获取学校信息存入redis
     *
     * @throws Exception
     */
    public void fetchSchoolSaveRedis() throws Exception {
        for (int i = 1; i < schoolSize / pageSize + 1; i++) {
            String url = String.format("https://api.eol.cn/gkcx/api/?access_token=&admissions=&central=&department=&dual_class=&f211=&f985=&is_dual_class=&keyword=&page=%d&province_id=&request_type=1&school_type=&signsafe=&size=20&sort=view_total&type=&uri=apigkcx/api/school/hotlists", i);
            String result = RestTemplateProxy.fetch(url);
            System.out.println(url);
            redisTemplate.opsForValue().set(RedisKey.School.schoolPage + i, result, RedisKey.oneYear, TimeUnit.SECONDS);
            Thread.sleep(500);
        }
    }

    /**
     * 从学校的redis中获取学校id保存redis
     *
     * @throws Exception
     */
    public void fetchAllSchoolIdSavRedis() throws Exception {
        List<Integer> schoolIds = new ArrayList<>();
        for (int i = 1; i < schoolSize / pageSize + 1; i++) {
            String pageResult = redisTemplate.opsForValue().get(RedisKey.School.schoolPage + i);
            JsonNode node = JacksonJsonUtil.readNode(pageResult, "/data/item");
            if (node != null) {
                List<SchoolDTO> schools = JacksonJsonUtil.parseArray(node.toString(), SchoolDTO.class);

                schools.stream().forEach(o -> {
                    schoolIds.add(o.getSchoolId());
                    redisTemplate.opsForValue().set(RedisKey.School.schoolIdpre + o.getSchoolId(), JacksonJsonUtil.toJsonString(o), RedisKey.oneYear, TimeUnit.SECONDS);
                });
            }
        }
        Collections.sort(schoolIds);
        String schoolIdsStr = String.join(RedisKey.splitStr, schoolIds.stream().map(o -> o.toString()).collect(Collectors.toList()));
        System.out.println(schoolIdsStr);
        redisTemplate.opsForValue().set(RedisKey.School.allSchoolIds, schoolIdsStr, RedisKey.oneYear, TimeUnit.SECONDS);
    }

    public void syncToDBBySchoolId(String schoolId) throws IOException {
        String schoolInfoInRedis = redisTemplate.opsForValue().get(RedisKey.School.schoolIdpre + schoolId);
        SchoolDTO school = JacksonJsonUtil.parseObject(schoolInfoInRedis, SchoolDTO.class);
        SchoolInfo schoolInfo = schoolAdapter.schoolDTOToSchoolInfo(school);

        SchoolInfoExample example = new SchoolInfoExample();
        example.createCriteria()
                .andSchoolIdEqualTo(school.getSchoolId());
        int rowNumber = schoolInfoMapper.updateByExampleSelective(schoolInfo, example);
        if (rowNumber <= 0) {
            schoolInfoMapper.insertSelective(schoolInfo);
        }
    }

    public void syncToDB() throws IOException {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            syncToDBBySchoolId(schoolId);
        }
    }
}
