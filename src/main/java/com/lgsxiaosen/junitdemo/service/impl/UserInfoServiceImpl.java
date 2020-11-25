package com.lgsxiaosen.junitdemo.service.impl;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liuguisen
 * @date 2020/11/25
 **/
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Override
    public UserInfoDto getUserInfo(Integer id) {

        return null;
    }

    /**
     * 保存用户信息
     * @param userInfoDto
     * @return
     */
    @Override
    public UserInfoDto saveUser(UserInfoDto userInfoDto) {

        return null;
    }
}
