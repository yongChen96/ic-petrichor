package com.petrichor.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.RoleService;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", description = "角色表")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

}
