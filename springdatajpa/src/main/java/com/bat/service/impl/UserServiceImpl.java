package com.bat.service.impl;

import com.bat.DO.UserDO;
import com.bat.dao.UserDao;
import com.bat.service.UserService;
import com.bat.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description UserServiceImpl
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/21 13:08
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public List<UserDO> getUserDOList() {
        return this.userDao.findAll();
    }

    public UserDO addUserDO(UserDO userDO) {
        userDO.setUserUuid(CommonUtils.getRandomUuid());
        return this.userDao.save(userDO);
    }
}
