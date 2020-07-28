package com.lexiangmiao.sample.cee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mzxiao on 2020/7/27 9:28
 */
public class ScoresPerYears {
    public static String fetchById(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        return response.getStatusCode().equals(HttpStatus.OK) ? response.getBody() : "";
    }

}
