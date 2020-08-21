package com.petrichor.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.SysLogService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-21
 */
@RestController
@RequestMapping("/sys-log")
@Api(value = "SysLogController", description = "")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

}
