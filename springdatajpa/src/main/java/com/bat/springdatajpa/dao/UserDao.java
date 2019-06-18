package com.bat.springdatajpa.dao;

import com.bat.springdatajpa.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 持久层 Dao
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
public interface UserDao extends JpaRepository<UserDO, Integer>, JpaSpecificationExecutor<UserDao>, Serializable {
}