package com.petrichor.system.controller;

import com.example.common.baseclass.BaseController;
import com.example.common.restful.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SystemController
 * @Description: 用户登录注册控制器
 * @Author: yongchen
 * @Date: 2020/8/21 11:00
 **/
@RestController
@RequestMapping("/system")
@Api(value = "用户登录注册控制器", tags = "用户登录注册控制器")
public class SystemController extends BaseController {

    /**
     * @Author: yongchen
     * @Description: 用户登录
     * @Date: 11:02 2020/8/21
     * @Param: []
     * @return: com.example.common.restful.Result
     **/
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")

    public Result login(){



        return null;
    }




}
