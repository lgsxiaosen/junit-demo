package com.lgsxiaosen.junitdemo.service.impl;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.DbService;
import com.lgsxiaosen.junitdemo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date 2020/11/25
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private DbService dbService;


    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Override
    public UserInfoDto getUserInfo(Integer id) {
        return dbService.queryInfo(id);
    }

    /**
     * 保存用户信息
     * @param userInfoDto
     * @return
     */
    @Override
    public UserInfoDto saveUser(UserInfoDto userInfoDto) {
        return dbService.saveInfo(userInfoDto);
    }
}
