package com.lgsxiaosen.junitdemo.service;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lgs
 * @date 2020/11/25
 **/
@SpringBootTest(classes = {UserInfoServiceImpl.class})
//@RunWith(SpringRunner.class)
//@ActiveProfiles("publish")
public class UserInfoServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @MockBean
    private DbService dbService;
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
        Mockito.when(dbService.queryInfo(Mockito.anyInt())).thenReturn(userInfoDto);
        UserInfoDto userInfoDto1 = userInfoService.getUserInfo(id);
        Assertions.assertEquals(userInfoDto1.getId(), id);
    }


    @Test
    public void saveUserTest(){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(2);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        Mockito.when(dbService.saveInfo(Mockito.any(UserInfoDto.class))).thenReturn(userInfoDto);
        UserInfoDto userInfoDto1 = userInfoService.saveUser(userInfoDto);
        Assertions.assertEquals(userInfoDto1.getId(), userInfoDto.getId());
    }



}
