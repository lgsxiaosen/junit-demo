package com.lgsxiaosen.junitdemo.service.impl;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author
 * @date 2020/11/25
 **/
@Service
public class DbServiceImpl implements DbService {
    private static final Logger logger = LoggerFactory.getLogger(DbServiceImpl.class);

    @Override
    public UserInfoDto queryInfo(Integer id) {
        logger.info("查询数据，id={}", id);
        int userId = 4;
        if (!Objects.equals(id, userId)){
            return null;
        }
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(id);
        userInfoDto.setAge(24);
        userInfoDto.setPassword("dwefsd");
        userInfoDto.setUsername("xiaoming");
        return userInfoDto;
    }

    @Override
    public UserInfoDto saveInfo(UserInfoDto userInfoDto) {
        if (Objects.isNull(userInfoDto)){
            return userInfoDto;
        }
        logger.info("添加数据：{}", userInfoDto);
        return userInfoDto;
    }
}
