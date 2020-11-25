package com.lgsxiaosen.junitdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lgs
 * @date 2020/11/25
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserInfoControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoControllerTest.class);

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void query(){
        String result = this.restTemplate.getForObject("/user/query?id=4", String.class);
        Assertions.assertThat(result).contains("4");
    }

    @Test
    public void saveTest() throws JsonProcessingException {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(2);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(mapper.writeValueAsString(userInfoDto), requestHeaders);
        ResponseEntity<String> result = restTemplate.postForEntity("/user/save", requestEntity, String.class);
        Assertions.assertThat(result.getBody()).contains("123");
    }

}
