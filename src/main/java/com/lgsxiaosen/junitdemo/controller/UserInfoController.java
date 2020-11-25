package com.lgsxiaosen.junitdemo.controller;

import com.lgsxiaosen.junitdemo.dto.UserInfoDto;
import com.lgsxiaosen.junitdemo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @author lgs
 * @date 2020/11/25
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/save")
    public UserInfoDto saveUser(@RequestBody UserInfoDto userInfoDto){
        return userInfoService.saveUser(userInfoDto);
    }

    @GetMapping("/query")
    public UserInfoDto queryUser(@PathParam("id") Integer id){
        return userInfoService.getUserInfo(id);
    }


}
