package com.bat.springdatajpa.controller;

import com.bat.springdatajpa.entity.UserDO;
import com.bat.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JPA 测试控制层
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@RestController
public class JpaTestController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public List<UserDO> getUserList() {
        return this.userService.getUserDOList();
    }

    @PostMapping("/addUserDO")
    public UserDO addUserDO(@RequestBody UserDO userDO) {
        return this.userService.addUserDO(userDO);
    }
}