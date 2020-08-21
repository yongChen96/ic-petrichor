package com.petrichor.system.service;

import com.petrichor.system.entity.dto.LoginDTO;
import com.petrichor.system.entity.SecurityUser;

import java.util.Map;

/**
 * @ClassName: SystemService
 * @Description: 登录注册服务
 * @Author: yongchen
 * @Date: 2020/8/21 15:48
 **/
public interface SystemService {


    /**
     * @Author: yongchen
     * @Description: 登录信息校验
     * @Date: 16:06 2020/8/21
     * @Param: [loginDTO]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String, Object> checkLoginInfo(LoginDTO loginDTO);

    /**
     * @Author: yongchen
     * @Description: 用户注册
     * @Date: 16:25 2020/8/21
     * @Param: [username, password]
     * @return: java.lang.Boolean
     **/
    Boolean register(String username, String password);

    /**
     * @Author: yongchen
     * @Description: 获取刷新Token
     * @Date: 16:23 2020/8/21
     * @Param: [oldToken]
     * @return: java.util.Map<java.lang.String,java.lang.String>
     **/
    Map<String, String> getRefreshToken(String oldToken);
}
