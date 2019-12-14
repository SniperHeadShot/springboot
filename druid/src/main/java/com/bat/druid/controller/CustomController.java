package com.bat.druid.controller;

import com.bat.druid.po.UserInfo;
import com.bat.druid.service.CustomUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * 测试主类
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 15:12
 **/
@Slf4j
@RestController
@RequestMapping("/db")
public class CustomController {

    private static final Random RAND = new Random();

    private static final String[] SOURCE_LIST = {"test1", "test2"};

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/user/list")
    public String testGet(@RequestParam(value = "username", required = false) String username) {
        List<UserInfo> result = customUserService.getCustomUserList(SOURCE_LIST[RAND.nextInt(SOURCE_LIST.length)], username);
        return result == null ? "failure" : "success";
    }

    @PostMapping("/user/{count}")
    public String testAdd(@PathVariable Long count) {
        boolean dbFlag = customUserService.insertCustomUser(SOURCE_LIST[RAND.nextInt(SOURCE_LIST.length)], count);
        return dbFlag ? "success" : "failure";
    }
}
