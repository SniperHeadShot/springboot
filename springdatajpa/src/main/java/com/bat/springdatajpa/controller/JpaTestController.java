package com.bat.controller;

import com.bat.DO.UserDO;
import com.bat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName JpaTestController
 * @Description JPA 测试控制层
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/21 11:47
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