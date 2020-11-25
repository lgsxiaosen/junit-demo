package com.lgsxiaosen.junitdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author lgs
 * @date 2020/11/25
 * junit为4版本时，需要添加
 * @SpringBootTest(classes = {EntityTypeController.class})
 * @AutoConfigureMockMvc
 * @ActiveProfiles("publish")
 * @RunWith(SpringRunner.class) 注解，在controller类添加@EnableWebMvc才可以使用
 **/
@WebMvcTest(UserInfoController.class)
public class UserInfoControllerTest2 {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoControllerTest2.class);

    @MockBean
    private UserInfoService userInfoService;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void queryTest() throws Exception {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(4);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        Mockito.when(userInfoService.getUserInfo(Mockito.anyInt())).thenReturn(userInfoDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/query")
                .param("id", "4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(4);
        userInfoDto.setUsername("test");
        userInfoDto.setPassword("123");
        userInfoDto.setAge(18);
        Mockito.when(userInfoService.saveUser(Mockito.any(UserInfoDto.class))).thenReturn(userInfoDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/query")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(userInfoDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
