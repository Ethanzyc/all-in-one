package com.ethanzyc.allinone.httpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author ethan
 * @date 2019/6/26 09:05
 */
@RestController
public class RestTemplateOk {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("http")
    public String testOk() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8088/test/exception", String.class);
        String body = forEntity.getBody();
        System.out.println(body);
        return body;
    }
}
