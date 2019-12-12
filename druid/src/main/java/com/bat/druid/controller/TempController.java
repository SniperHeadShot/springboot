package com.bat.druid.controller;

import com.bat.druid.po.UserInfo;
import com.bat.druid.service.CustomUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试主类
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 15:12
 **/
@Slf4j
@RestController
@RequestMapping("/db")
public class TempController {

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/user/list")
    public String testGet(@RequestParam(value = "username", required = false) String username) {
        List<UserInfo> result = customUserService.getCustomUserList("test1", username);
        return result == null || result.size() == 0 ? "failure" : "success";
    }

    @PostMapping("/user/{count}")
    public String testAdd(@PathVariable Long count) {
        boolean dbFlag = customUserService.insertCustomUser("test1", count);
        return dbFlag ? "success" : "failure";
    }
}
