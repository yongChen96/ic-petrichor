package com.petrichor.system.service;

import com.petrichor.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
public interface UserService extends IService<User> {

    /**
     * @Author: yongchen
     * @Description: 获取用户信息
     * @Date: 10:05 2020/8/21
     * @Param: [username]
     * @return: org.springframework.security.core.userdetails.UserDetails
     **/
    UserDetails loadUserByUsername(String username);

}
