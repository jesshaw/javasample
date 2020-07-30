package com.lexiangmiao.sample.cee;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/27 9:31
 * <p>
 * https://api.eol.cn/gkcx/api/?access_token=&admissions=&central=&department=&dual_class=&f211=&f985=&is_dual_class=&keyword=&page=1&province_id=&request_type=1&school_type=&signsafe=&size=3000&sort=view_total&type=&uri=apigkcx/api/school/hotlists
 */
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {BeanConfig.class})
public class ScoresPerYearsTest {
    final String schoolPage = "school_page_";
    final String allSchoolIds = "all_school_ids";
    final String schoolIdpre = "school_";
    final String schoolPerYearScore = "school_per_year_score_%s/43/2/1.json";
    final String schoolIdSplit = ",";
    final int schoolSize = 2941;
    final int pageSize = 20;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    ExcelDownloadSvc excelDownloadSvc;
    int oneYearTimeout = 365 * 24 * 60 * 60;

    @Test
    public void fetchScoresPerYearSaveRedis() throws Exception {
        String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
        for (String item : allSchoolIdsStr.split(schoolIdSplit)) {
            // e.g. https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/北京大学/湖南/文科/1.json
            String url = "https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/" + item + "/43/2/1.json";
            String result = ScoresPerYears.fetchById(url);
            System.out.println(url);
            redisTemplate.opsForValue().set(String.format(schoolPerYearScore, item), result, oneYearTimeout, TimeUnit.SECONDS);
            Thread.sleep(500);
        }
    }

    @Test
    public void fetchScoresPerYearIfEmptyResaveRedis() throws Exception {
        String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
        for (String item : allSchoolIdsStr.split(schoolIdSplit)) {
            String redisStr = redisTemplate.opsForValue().get(String.format(schoolPerYearScore, item));
            if ("\"\"".equals(redisStr) || StringUtils.isEmpty(redisStr)) {
                String url = "https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/" + item + "/43/2/1.json";
                String result = ScoresPerYears.fetchById(url);
                System.out.println(url);
                redisTemplate.opsForValue().set(String.format(schoolPerYearScore, item), result, oneYearTimeout, TimeUnit.SECONDS);
                Thread.sleep(500);
            }
        }
    }


    @Test
    public void fetchScoresPerYearVerify() throws Exception {
        String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
        System.out.println(allSchoolIdsStr);
        System.out.println(redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 386)));
        System.out.println("");
        System.out.println(redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 3554)));

        String s = redisTemplate.opsForValue().get(String.format(schoolPerYearScore, 3554));
        Assert.assertTrue(s.equals("\"\""));
    }

    private String minScorce(String source, String schoolPerYearScore) {
        if ("--".equals(schoolPerYearScore)) {
            return "0";
        }
        if ("0".equals(source)) {
            return schoolPerYearScore;
        } else if (Double.parseDouble(schoolPerYearScore) < Double.parseDouble(source)) {
            return schoolPerYearScore;
        }
        return schoolPerYearScore;
    }

    private String convert0(String schoolPerYearScore) {
        if ("--".equals(schoolPerYearScore)) {
            return "0";
        }
        return schoolPerYearScore;
    }

    @Test
    public void fetchScoresPerYearSaveRedisForCvs() throws Exception {
//        String[]batchIds=["7","8"]; // 7 本科一批 8 本科二批
        Map<String, String> batchIds = new HashMap<>();
//        batchIds.put("7", "本科一批");
        batchIds.put("8", "本科二批");
        for (Map.Entry<String, String> entry : batchIds.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            String batchControl = entry.getKey(); // 7 本科一批 8 本科二批

            String zslx = "0"; // 0 普通类
            List<ScoresPerYear> scoresPerYears = new ArrayList<>();
            String allSchoolIdsStr = redisTemplate.opsForValue().get(allSchoolIds);
            for (String item : allSchoolIdsStr.split(schoolIdSplit)) {
//            if (Integer.parseInt(item) != 386)
//                continue;
                String redisStr = redisTemplate.opsForValue().get(String.format(schoolPerYearScore, item));
                School school = JacksonJsonUtil.parseObject(redisTemplate.opsForValue().get(schoolIdpre + item), School.class);
                ScoresPerYear finalScoresPerYear = null;
                if (!("\"\"".equals(redisStr) || StringUtils.isEmpty(redisStr))) {
                    JsonNode node = JacksonJsonUtil.readNode(redisStr, "/data/item");
                    if (node != null) {
                        List<ScoresPerYear> scoresPerYearList = JacksonJsonUtil.parseArray(node.toString(), ScoresPerYear.class);
                        for (ScoresPerYear score : scoresPerYearList) {
                            if (batchControl.equals(score.getBatchControl())) {
                                finalScoresPerYear = scoresPerYearList.get(0);
                                finalScoresPerYear.setSchoolName(school.getName());
                                finalScoresPerYear.setCityName(school.getCityName());
                                finalScoresPerYear.setLevelName(school.getLevelName());
                                finalScoresPerYear.setProvinceName(school.getProvinceName());
                                finalScoresPerYear.setLocalBatchName(score.getLocalBatchName());
                                if ("2019".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2019(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2019s(convert0(score.getMin()));
                                    }
                                } else if ("2018".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2018(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2018s(convert0(score.getMin()));
                                    }
                                } else if ("2017".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2017(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2017s(convert0(score.getMin()));
                                    }
                                } else if ("2016".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2016(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2016s(convert0(score.getMin()));
                                    }
                                } else if ("2015".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2015(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2015s(convert0(score.getMin()));
                                    }
                                } else if ("2014".equals(score.getYear())) {
                                    if (zslx.equals(score.getZslx())) {
                                        finalScoresPerYear.setMinScore2014(convert0(score.getMin()));
                                    } else {
                                        finalScoresPerYear.setMinScore2014s(convert0(score.getMin()));
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(JacksonJsonUtil.toJsonStringWithDefaultPrettyPrinter(scoresPerYears));


                if (finalScoresPerYear != null) {
                    scoresPerYears.add(finalScoresPerYear);
                }
//            break;
            }

            System.out.println(System.getProperty("user.dir"));

            String str1 = System.getProperty("user.dir") + "/湖南文科" + entry.getValue() + "历年全国最低录取分数.xlsx";
            try {
                Workbook wb = excelDownloadSvc.scoresPerYearsToExcel(scoresPerYears);
                FileOutputStream out = new FileOutputStream(str1);
                wb.write(out);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void fetchSchoolVerify() throws Exception {
        System.out.println(redisTemplate.opsForValue().get(schoolPage + 1));
        System.out.println("");
        System.out.println(redisTemplate.opsForValue().get(schoolPage + 147));
    }

    @Test
    public void fetchAllSchoolIdsVerify() throws Exception {
        System.out.println(redisTemplate.opsForValue().get(allSchoolIds));
    }


}