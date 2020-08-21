package com.petrichor.system.config.security;

import com.example.security.security.SecurityConfig;
import com.petrichor.system.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * @ClassName: SystemSecurity
 * @Description: 模块Security相关配置
 * @Author: yongchen
 * @Date: 2020/8/21 9:57
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SystemSecurity extends SecurityConfig {

    @Resource
    private UserService userService;

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userService.loadUserByUsername(username);
    }
}
