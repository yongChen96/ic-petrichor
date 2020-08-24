package com.petrichor.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.SysAttService;

/**
 * <p>
 * 附件信息表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-24
 */
@RestController
@RequestMapping("/sysAtt")
@Api(value = "SysAttController", description = "附件信息表")
public class SysAttController extends BaseController {

    @Autowired
    private SysAttService sysAttService;

}
