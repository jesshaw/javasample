package com.lexiangmiao.sample.svc;

import com.fasterxml.jackson.databind.JsonNode;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlan;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlan;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlanExample;
import com.lexiangmiao.sample.mybatis.repository.cee.SchoolPlanMapper;
import com.lexiangmiao.sample.svc.dto.*;
import com.lexiangmiao.sample.svc.mapper.SchoolPlanAdapter;
import com.lexiangmiao.sample.util.JacksonJsonUtil;
import com.lexiangmiao.sample.util.RestTemplateProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mzxiao on 2020/7/29 17:26
 */
@Service
public class SchoolPlanSvc {

    private final RedisTemplate<String, String> redisTemplate;
    private final SchoolRedisSvc schoolRedisSvc;
    private final SchoolPlanMapper schoolPlanMapper;
    private final SchoolPlanAdapter schoolPlanAdapter;

    public SchoolPlanSvc(RedisTemplate<String, String> redisTemplate, SchoolRedisSvc schoolRedisSvc, SchoolPlanMapper schoolPlanMapper, SchoolPlanAdapter schoolPlanAdapter) {
        this.redisTemplate = redisTemplate;
        this.schoolRedisSvc = schoolRedisSvc;
        this.schoolPlanMapper = schoolPlanMapper;
        this.schoolPlanAdapter = schoolPlanAdapter;
    }

    public void fetchAllSchoolPlanSaveRedis() throws Exception {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            if (Integer.parseInt(schoolId) > 640) {
                for (Integer year : Year.getAllValues()) {
                    for (Integer batch : AdmissionBatch.getAllValues()) {
                        fetchSchoolPlanSaveRedisBy(year, schoolId, SubjectType.LIBERAL_ARTS.value(), batch, 200);
                    }
                }
            }
        }
    }

    public void fetchSchoolPlanSaveRedis(String schoolId) throws Exception {
        for (Integer year : Year.getAllValues()) {
            for (Integer batch : AdmissionBatch.getAllValues()) {
                fetchSchoolPlanSaveRedisBy(year, schoolId, SubjectType.LIBERAL_ARTS.value(), batch, 200);
            }
        }
    }

    public String generateKey(Integer year, String schoolId, Integer subjectType, Integer batch, int pageSize) {
        return String.format(RedisKey.SchoolPlan.pre, year, schoolId, subjectType, batch, pageSize);
    }

    /**
     * @param year              年份
     * @param schoolId
     * @param subjectType       文理科类型
     * @param sleepMilliseconds
     * @throws InterruptedException
     */
    public void fetchSchoolPlanSaveRedisBy(Integer year, String schoolId, Integer subjectType, Integer batch, int sleepMilliseconds) throws InterruptedException {
        // https://static-data.eol.cn/www/2.0/schoolplanindex/年份/学校/在湖南/文科/批次/1.json
        // https://static-data.eol.cn/www/2.0/schoolplanindex/2020/402/43/2/7/1.json
        String result;
        int pageSize = 1;
        do {
            String key = generateKey(year, schoolId, subjectType, batch, pageSize);
            String url = String.format("https://static-data.eol.cn/www/2.0/%s", key);
            result = RestTemplateProxy.fetch(url);
            System.out.println(url);
            redisTemplate.opsForValue().set(key, result, RedisKey.oneYear, TimeUnit.SECONDS);
            Thread.sleep(sleepMilliseconds);
            pageSize++;
        } while (!"\"\"".equals(result));
    }

    public void syncToDBBySchoolId(String schoolId) throws IOException {
        for (Integer year : Year.getAllValues()) {
            for (Integer batch : AdmissionBatch.getAllValues()) {
                int pageSize = 1;
                String redisValue;
                do {
                    String key = generateKey(year, schoolId, SubjectType.LIBERAL_ARTS.value(), batch, pageSize);
                    redisValue = redisTemplate.opsForValue().get(key);
                    JsonNode node = JacksonJsonUtil.readNode(redisValue, "/data/item");
                    if (node != null && !"".equals(node.toString())) {
                        List<SchoolPlanDTO> dtos = JacksonJsonUtil.parseArray(node.toString(), SchoolPlanDTO.class);
                        for (SchoolPlanDTO dto :
                                dtos) {
                            dto.setYear(year);
                            SchoolPlan schoolPlan = schoolPlanAdapter.schoolPlanDTOToSchoolPlan(dto);

                            SchoolPlanExample example = new SchoolPlanExample();
                            example.createCriteria()
                                    .andSchoolIdEqualTo(schoolPlan.getSchoolId())
                                    .andYearEqualTo(schoolPlan.getYear())
                                    .andTypeEqualTo(schoolPlan.getType())
                                    .andSpecialIdEqualTo(schoolPlan.getSpecialId())
                                    .andProvinceEqualTo(schoolPlan.getProvince());
                            int rowNumber = schoolPlanMapper.updateByExampleSelective(schoolPlan, example);
                            if (rowNumber <= 0) {
                                schoolPlanMapper.insertSelective(schoolPlan);
                            }
                        }
                    }
                    pageSize++;
                }
                while (!"\"\"".equals(redisValue) && !StringUtils.isEmpty(redisValue));
            }
        }

    }

    public void syncToDB() throws IOException {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            syncToDBBySchoolId(schoolId);
        }
    }
}
