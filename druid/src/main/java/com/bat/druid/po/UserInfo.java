package com.bat.druid.po;

import lombok.Data;

/**
 * 数据库实体
 *
 * @author ZhengYu
 * @version 1.0 2019/12/12 11:17
 **/
@Data
public class UserInfo {

    private Long keyId;

    private String userUuid;

    private String username;

    private String password;

    private String birthday;

    private String address;
}
