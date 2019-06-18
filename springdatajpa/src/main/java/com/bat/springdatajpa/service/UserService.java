package com.bat.springdatajpa.service;

import com.bat.springdatajpa.entity.UserDO;

import java.util.List;

/**
 * 用户服务
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
public interface UserService {

    /**
     * 获取用户列表
     *
     * @return java.util.List<com.bat.springdatajpa.entity.UserDO>
     * @author ZhengYu
     */
    List<UserDO> getUserDOList();

    /**
     * 添加用户
     *
     * @param userDO 用户实体
     * @return com.bat.springdatajpa.entity.UserDO
     * @author ZhengYu
     */
    UserDO addUserDO(UserDO userDO);
}
