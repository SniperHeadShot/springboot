package com.bat.druid.dao;

import com.bat.druid.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据中心
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:46
 **/
@Mapper
public interface CustomUserDao {

    /**
     * 查
     *
     * @param username 用户名
     * @return java.util.List<com.bat.druid.po.UserInfo>
     * @author ZhengYu
     */
    List<UserInfo> getUserInfoList(@Param("username") String username);

    /**
     * 增
     *
     * @param userInfo 增
     * @return int
     * @author ZhengYu
     */
    int insertUser(UserInfo userInfo);
}
