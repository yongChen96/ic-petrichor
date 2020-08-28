package com.petrichor.system.controller;


import com.example.common.restful.Result;
import com.petrichor.system.entity.SysAtt;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.example.common.baseclass.BaseController;
import io.swagger.annotations.Api;
import com.petrichor.system.service.SysAttService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

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

    @Resource
    private SysAttService sysAttService;

    /**
     * @Author: yongchen
     * @Description: 上传单个附件
     * @Date: 9:50 2020/8/25
     * @Param: [file]
     * @return: com.example.common.restful.Result
     **/
    @PostMapping("/uploadFile")
    @ApiOperation(value = "上传单个附件", notes = "上传单个附件")
    public Result<SysAtt> uploadFile(@RequestParam("file") MultipartFile file) {
        return success(sysAttService.uploadFile(file));
    }

}
