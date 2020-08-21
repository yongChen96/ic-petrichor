package com.petrichor.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.UserService;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "用户信息表")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

}
