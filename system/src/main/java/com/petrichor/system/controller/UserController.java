package com.petrichor.system.controller;


import com.example.common.annotation.loginuser.InjectUser;
import com.example.common.annotation.loginuser.User;
import com.example.common.restful.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

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

    /**
     * @Author: yongchen
     * @Description: 获取当前登录用户信息
     * @Date: 14:43 2020/8/27
     * @Param: [user]
     * @return: com.example.common.restful.Result<com.example.common.annotation.loginuser.User>
     **/
    @GetMapping("/userInfo")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result<User> getUserInfo(@ApiIgnore @InjectUser User user){
        return success(user);
    }
}
