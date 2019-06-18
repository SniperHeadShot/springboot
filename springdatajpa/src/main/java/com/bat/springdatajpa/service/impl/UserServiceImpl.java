package com.bat.springdatajpa.service.impl;

import com.bat.springdatajpa.entity.UserDO;
import com.bat.springdatajpa.dao.UserDao;
import com.bat.springdatajpa.service.UserService;
import com.bat.springdatajpa.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 获取用户列表
     *
     * @return java.util.List<com.bat.springdatajpa.entity.UserDO>
     * @author ZhengYu
     */
    @Override
    public List<UserDO> getUserDOList() {
        return this.userDao.findAll();
    }

    /**
     * 添加用户
     *
     * @param userDO 用户实体
     * @return com.bat.springdatajpa.entity.UserDO
     * @author ZhengYu
     */
    @Override
    public UserDO addUserDO(UserDO userDO) {
        userDO.setUserUuid(CommonUtils.getRandomUuid());
        return this.userDao.save(userDO);
    }
}
