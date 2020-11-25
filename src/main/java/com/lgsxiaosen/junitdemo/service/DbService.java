package com.lgsxiaosen.junitdemo.service;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;

public interface DbService {

    UserInfoDto queryInfo(Integer id);

    UserInfoDto saveInfo(UserInfoDto userInfoDto);
}
