package com.example.security.loginuser;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: 用户信息
 * @Author: yongchen
 * @Date: 2020/8/27 10:59
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1418363393638607996L;

    private String userId;

    private String userName;

    private String roleId;
}
