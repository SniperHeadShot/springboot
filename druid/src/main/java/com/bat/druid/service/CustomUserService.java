package com.bat.druid.service;

import com.bat.druid.po.UserInfo;

import java.util.List;

/**
 * CustomStructure Service
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:38
 **/
public interface CustomUserService {

    /**
     * 获取用户信息列表
     *
     * @param dbFlag   库
     * @param username 用户名
     * @return java.util.List<com.bat.druid.po.UserInfo>
     * @author ZhengYu
     */
    List<UserInfo> getCustomUserList(String dbFlag, String username);

    /**
     * 新增用户列表
     *
     * @param dbFlag 库
     * @param count  数量
     * @return boolean
     * @author ZhengYu
     */
    boolean insertCustomUser(String dbFlag, long count);
}
