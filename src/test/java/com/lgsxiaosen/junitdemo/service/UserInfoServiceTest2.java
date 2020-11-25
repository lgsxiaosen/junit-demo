package com.lgsxiaosen.junitdemo.service;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.impl.DbServiceImpl;
import com.lgsxiaosen.junitdemo.service.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lgs
 * @date 2020/11/25
 **/
@SpringBootTest(classes = {UserInfoServiceImpl.class, DbServiceImpl.class})
public class UserInfoServiceTest2 {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest2.class);

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Test
    public void queryTest(){
        int id = 4;
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(id);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        UserInfoDto userInfoDto1 = userInfoService.getUserInfo(id);
        Assertions.assertEquals(userInfoDto1.getId(), id);
    }

    @Test
    public void saveTest(){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(7);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        UserInfoDto userInfoDto1 = userInfoService.saveUser(userInfoDto);
        Assertions.assertEquals(userInfoDto1.getId(), userInfoDto.getId());
    }


}
