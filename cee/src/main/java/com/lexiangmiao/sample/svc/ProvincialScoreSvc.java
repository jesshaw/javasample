package com.lexiangmiao.sample.svc;

import com.fasterxml.jackson.databind.JsonNode;
import com.lexiangmiao.sample.mybatis.domain.cee.ProvincialScore;
import com.lexiangmiao.sample.mybatis.domain.cee.ProvincialScoreExample;
import com.lexiangmiao.sample.mybatis.repository.cee.ProvincialScoreMapper;
import com.lexiangmiao.sample.svc.dto.ProvincialScoreDTO;
import com.lexiangmiao.sample.svc.mapper.ProvincialScoreAdapter;
import com.lexiangmiao.sample.util.JacksonJsonUtil;
import com.lexiangmiao.sample.util.RestTemplateProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mzxiao on 2020/7/29 9:49
 */
@Service
public class ProvincialScoreSvc {

    private final RedisTemplate<String, String> redisTemplate;
    private final ProvincialScoreMapper provincialScoreMapper;
    private final ProvincialScoreAdapter provincialScoreAdapter;
    private final SchoolRedisSvc schoolRedisSvc;

    public ProvincialScoreSvc(RedisTemplate<String, String> redisTemplate, ProvincialScoreMapper provincialScoreMapper, ProvincialScoreAdapter provincialScoreAdapter, SchoolRedisSvc schoolRedisSvc) {
        this.redisTemplate = redisTemplate;
        this.provincialScoreMapper = provincialScoreMapper;
        this.provincialScoreAdapter = provincialScoreAdapter;
        this.schoolRedisSvc = schoolRedisSvc;
    }

    public void fetchAllProvicialScoresSaveRedis() throws Exception {
        for (String item : schoolRedisSvc.fetchAllSchoolIds()) {
            saveRedisBySchoolId(item, 500);
        }
    }

    public void saveRedisBySchoolId(String shcoolId, int sleepMilliseconds) throws InterruptedException {
        // e.g. https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/北京大学/湖南/文科/1.json
        String url = "https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/" + shcoolId + "/43/2/1.json";
        String result = RestTemplateProxy.fetch(url);
//            System.out.println(url);
        redisTemplate.opsForValue().set(String.format(RedisKey.ProvincialScore.schoolPerYearScore, shcoolId), result, RedisKey.oneYear, TimeUnit.SECONDS);
        Thread.sleep(sleepMilliseconds);
    }

    public void fetchAllProvicialScoresIfEmptyResaveRedis() throws Exception {
        for (String item : schoolRedisSvc.fetchAllSchoolIds()) {
            String redisStr = redisTemplate.opsForValue().get(String.format(RedisKey.ProvincialScore.schoolPerYearScore, item));
            if ("\"\"".equals(redisStr) || StringUtils.isEmpty(redisStr)) {
                saveRedisBySchoolId(item, 500);
            }
        }
    }

    public void syncToDBBySchoolId(String schoolId) throws IOException {
        String redisStr = redisTemplate.opsForValue().get(String.format(RedisKey.ProvincialScore.schoolPerYearScore, schoolId));
        if (!("\"\"".equals(redisStr) || StringUtils.isEmpty(redisStr))) {
            JsonNode node = JacksonJsonUtil.readNode(redisStr, "/data/item");
            if (node != null) {
                List<ProvincialScoreDTO> scoresPerYearList = JacksonJsonUtil.parseArray(node.toString(), ProvincialScoreDTO.class);
                scoresPerYearList.forEach(o -> save(o));
            }
        }

    }

    public void save(ProvincialScoreDTO dto) {
        ProvincialScore provincialScore = provincialScoreAdapter.provincialScoreDTOToProvincialScore(dto);
        ProvincialScoreExample example = new ProvincialScoreExample();
        example.createCriteria()
                .andSchoolIdEqualTo(dto.getSchoolId())
                .andProvinceIdEqualTo(dto.getProvinceId())
                .andTypeEqualTo(dto.getType())
                .andYearEqualTo(dto.getYear())
                .andZslxEqualTo(dto.getZslx())
                .andBatchEqualTo(dto.getBatch());

        int rowNumber = provincialScoreMapper.updateByExampleSelective(provincialScore, example);
        if (rowNumber <= 0) {
            provincialScoreMapper.insertSelective(provincialScore);
        }
    }

    public void syncToDB() throws IOException {
        for (String schoolId : schoolRedisSvc.fetchAllSchoolIds()) {
            syncToDBBySchoolId(schoolId);
        }
    }
////
//    public void fetchScoresPerYearSaveRedisForCvs() throws Exception {
////        String[]batchIds=["7","8"]; // 7 本科一批 8 本科二批
//        Map<String, String> batchIds = new HashMap<>();
////        batchIds.put("7", "本科一批");
//        batchIds.put("8", "本科二批");
//        for (Map.Entry<String, String> entry : batchIds.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//            String batchControl = entry.getKey(); // 7 本科一批 8 本科二批
//
//            String zslx = "0"; // 0 普通类
//            List<ScoresPerYear> scoresPerYears = new ArrayList<>();
//            String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
//            for (String item : allSchoolIdsStr.split(schoolIdSplit)) {
////            if (Integer.parseInt(item) != 386)
////                continue;
//                String redisStr = redisTemplate.opsForValue().get(String.format(schoolPerYearScore, item));
//                School school = JacksonJsonUtil.parseObject(redisTemplate.opsForValue().get(schoolIdpre + item), School.class);
//                ScoresPerYear finalScoresPerYear = null;
//                if (!("\"\"".equals(redisStr) || StringUtils.isEmpty(redisStr))) {
//                    JsonNode node = JacksonJsonUtil.readNode(redisStr, "/data/item");
//                    if (node != null) {
//                        List<ScoresPerYear> scoresPerYearList = JacksonJsonUtil.parseArray(node.toString(), ScoresPerYear.class);
//                        for (ScoresPerYear score : scoresPerYearList) {
//                            if (batchControl.equals(score.getBatchControl())) {
//                                finalScoresPerYear = scoresPerYearList.get(0);
//                                finalScoresPerYear.setSchoolName(school.getName());
//                                finalScoresPerYear.setCityName(school.getCityName());
//                                finalScoresPerYear.setLevelName(school.getLevelName());
//                                finalScoresPerYear.setProvinceName(school.getProvinceName());
//                                finalScoresPerYear.setLocalBatchName(score.getLocalBatchName());
//                                if ("2019".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2019(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2019s(convert0(score.getMin()));
//                                    }
//                                } else if ("2018".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2018(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2018s(convert0(score.getMin()));
//                                    }
//                                } else if ("2017".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2017(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2017s(convert0(score.getMin()));
//                                    }
//                                } else if ("2016".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2016(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2016s(convert0(score.getMin()));
//                                    }
//                                } else if ("2015".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2015(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2015s(convert0(score.getMin()));
//                                    }
//                                } else if ("2014".equals(score.getYear())) {
//                                    if (zslx.equals(score.getZslx())) {
//                                        finalScoresPerYear.setMinScore2014(convert0(score.getMin()));
//                                    } else {
//                                        finalScoresPerYear.setMinScore2014s(convert0(score.getMin()));
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                System.out.println(JacksonJsonUtil.toJsonStringWithDefaultPrettyPrinter(scoresPerYears));
//
//
//                if (finalScoresPerYear != null) {
//                    scoresPerYears.add(finalScoresPerYear);
//                }
////            break;
//            }
//
//            System.out.println(System.getProperty("user.dir"));
//
//            String str1 = System.getProperty("user.dir") + "/湖南文科" + entry.getValue() + "历年全国最低录取分数.xlsx";
//            try {
//                Workbook wb = excelDownloadSvc.scoresPerYearsToExcel(scoresPerYears);
//                FileOutputStream out = new FileOutputStream(str1);
//                wb.write(out);
//                out.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
}
