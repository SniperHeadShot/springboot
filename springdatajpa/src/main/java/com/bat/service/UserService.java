package com.bat.service;

import com.bat.DO.UserDO;

import java.util.List;

/**
 * @ClassName UserService
 * @Description UserService
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/21 13:07
 **/
public interface UserService {

    List<UserDO> getUserDOList();

    UserDO addUserDO(UserDO userDO);
}
