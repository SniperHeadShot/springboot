package com.bat.dao;

import com.bat.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/21 13:00
 **/
public interface UserDao extends JpaRepository<UserDO, Integer>, JpaSpecificationExecutor<UserDao>, Serializable {
}