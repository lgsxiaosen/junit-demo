package com.lgsxiaosen.junitdemo.service;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;

/**
 * @author liuguisen
 * @date 2020/11/25
 **/
public interface UserInfoService {

    UserInfoDto getUserInfo(Integer id);

    UserInfoDto saveUser(UserInfoDto userInfoDto);




}
