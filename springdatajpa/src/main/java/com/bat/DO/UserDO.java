package com.bat.DO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName UserDO
 * @Description User实体类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/21 11:52
 **/
@Data
@Entity
@Table(name = "t_user")
public class UserDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = false, name = "user_uuid", columnDefinition = "varchar(32)")
    private String userUuid;

    @Column(name = "username", columnDefinition = "varchar(50)")
    private String username;

    @Column(nullable = false, name = "password", columnDefinition = "varchar(50)")
    private String password;

    @Column(nullable = false, name = "account_expired", columnDefinition = "int")
    private Integer accountExpired;

    @Column(nullable = false, name = "account_locked", columnDefinition = "int")
    private Integer locked;

    @Column(nullable = false, name = "credentials_expired", columnDefinition = "int")
    private Integer credentialsExpired;

    @Column(nullable = false, name = "account_enabled", columnDefinition = "int")
    private Integer enabled;
}
