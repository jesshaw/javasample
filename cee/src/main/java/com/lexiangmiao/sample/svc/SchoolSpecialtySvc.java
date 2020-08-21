package com.lexiangmiao.sample.svc;

import com.fasterxml.jackson.databind.JsonNode;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialty;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialtyExample;
import com.lexiangmiao.sample.mybatis.repository.cee.SchoolSpecialtyMapper;
import com.lexiangmiao.sample.svc.dto.SchoolSpecialtyDTO;
import com.lexiangmiao.sample.svc.dto.SubjectType;
import com.lexiangmiao.sample.svc.dto.Year;
import com.lexiangmiao.sample.svc.mapper.SchoolSpecialtyAdapter;
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
public class SchoolSpecialtySvc {
    private final RedisTemplate<String, String> redisTemplate;
    private final SchoolRedisSvc schoolRedisSvc;
    private final SchoolSpecialtyAdapter schoolSpecialtyAdapter;
    private final SchoolSpecialtyMapper schoolSpecialtyMapper;

    public SchoolSpecialtySvc(RedisTemplate<String, String> redisTemplate, SchoolRedisSvc schoolRedisSvc, SchoolSpecialtyAdapter schoolSpecialtyAdapter, SchoolSpecialtyMapper schoolSpecialtyMapper) {
        this.redisTemplate = redisTemplate;
        this.schoolRedisSvc = schoolRedisSvc;
        this.schoolSpecialtyAdapter = schoolSpecialtyAdapter;
        this.schoolSpecialtyMapper = schoolSpecialtyMapper;
    }

    public void fetchAllSchoolSpecialtySaveRedis() throws Exception {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
//            if (Integer.parseInt(schoolId)>1074) {
            for (Integer year : Year.getValuesNotEquals(2020)) {
                fetchSchoolSpecialtySaveRedisBy(year, schoolId, SubjectType.LIBERAL_ARTS.value(), 200);
            }
//            }
        }
    }

    public void fetchSchoolSpecialtySaveRedis(String schoolId) throws Exception {
        for (Integer year : Year.getValuesNotEquals(2020)) {
            fetchSchoolSpecialtySaveRedisBy(year, schoolId, SubjectType.LIBERAL_ARTS.value(), 200);
        }
    }


    public String generateKey(Integer year, String schoolId, Integer subjectType, int pageSize) {
        return String.format(RedisKey.SchoolSpecialty.pre, year, schoolId, subjectType, pageSize);
    }

    /**
     * @param year              年份
     * @param schoolId
     * @param subjectType       文理科类型
     * @param sleepMilliseconds
     * @throws InterruptedException
     */
    public void fetchSchoolSpecialtySaveRedisBy(Integer year, String schoolId, Integer subjectType, int sleepMilliseconds) throws InterruptedException {
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/年份/分校/湖南/文科/第几页.json
//    https://static-data.eol.cn/www/2.0/schoolspecialindex/2019/402/43/2/1.json
        String result;
        int pageSize = 1;
        do {
            String key = generateKey(year, schoolId, subjectType, pageSize);
            String url = String.format("https://static-data.eol.cn/www/2.0/%s", key);
            result = RestTemplateProxy.fetch(url);
            System.out.println(url);
            redisTemplate.opsForValue().set(key, result, RedisKey.oneYear, TimeUnit.SECONDS);
            Thread.sleep(sleepMilliseconds);
            pageSize++;
        } while (!"\"\"".equals(result));
    }

    public void syncToDBBySchoolId(String schoolId) throws IOException {
        for (Integer year : Year.getValuesNotEquals(2020)) {
            int pageSize = 1;
            String redisValue;
            do {
                String key = generateKey(year, schoolId, SubjectType.LIBERAL_ARTS.value(), pageSize);
                redisValue = redisTemplate.opsForValue().get(key);
                JsonNode node = JacksonJsonUtil.readNode(redisValue, "/data/item");
                if (node != null && !"".equals(node.toString())) {
                    List<SchoolSpecialtyDTO> dtos = JacksonJsonUtil.parseArray(node.toString(), SchoolSpecialtyDTO.class);
                    for (SchoolSpecialtyDTO dto : dtos) {
                        dto.setYear(year);
                        SchoolSpecialty schoolSpecialty = schoolSpecialtyAdapter.schoolSpecialtyDTOToSchoolSpecialty(dto);

                        SchoolSpecialtyExample example = new SchoolSpecialtyExample();
                        example.createCriteria()
                                .andSchoolIdEqualTo(schoolSpecialty.getSchoolId())
                                .andYearEqualTo(schoolSpecialty.getYear())
                                .andTypeEqualTo(schoolSpecialty.getType())
                                .andSpecialIdEqualTo(schoolSpecialty.getSpecialId())
                        ;
                        int rowNumber = schoolSpecialtyMapper.updateByExampleSelective(schoolSpecialty, example);
                        if (rowNumber <= 0) {
                            schoolSpecialtyMapper.insertSelective(schoolSpecialty);
                        }
                    }
                }
                pageSize++;
            } while (!"\"\"".equals(redisValue) && !StringUtils.isEmpty(redisValue));
        }

    }

    public void syncToDB() throws IOException {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            syncToDBBySchoolId(schoolId);
        }
    }
}
