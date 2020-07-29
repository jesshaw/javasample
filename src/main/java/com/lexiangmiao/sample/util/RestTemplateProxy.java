package com.lexiangmiao.sample.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mzxiao on 2020/7/29 9:05
 */
public final class RestTemplateProxy {
    private RestTemplateProxy() {
    }

    public static String fetch(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        return response.getStatusCode().equals(HttpStatus.OK) ? response.getBody() : "";
    }
}
