package com.petrichor.system.controller;

import com.example.common.baseclass.BaseController;
import com.example.common.restful.Result;
import com.example.common.utils.CaptchaUtil;
import com.petrichor.system.entity.dto.LoginDTO;
import com.petrichor.system.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private SystemService systemService;
    @Resource
    private RedisTemplate redisTemplate;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @GetMapping(value = "/getCaptch",produces = "image/png")
    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    public void getCaptch(@RequestParam String captchKey, HttpServletResponse response) throws IOException {
        //生成4位随机验证码
        String captchValue= new CaptchaUtil().randomStr(4);
        //id和验证码存入redis，3分钟有效
        redisTemplate.opsForValue().set("captch:"+captchKey, captchValue, 3L, TimeUnit.MINUTES);
        //指定验证码长宽
        CaptchaUtil captchaUtil = new CaptchaUtil(116,36,4,10, captchValue);
        captchaUtil.write(response.getOutputStream());
    }

    /**
     * @Author: yongchen
     * @Description: 用户登录
     * @Date: 11:02 2020/8/21
     * @Param: [com.petrichor.system.entity.dto.LoginDTO]
     * @return: com.example.common.restful.Result
     **/
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public Result login(@RequestBody LoginDTO loginDTO){
        if (StringUtils.isBlank(loginDTO.getCaptchValue())){
            return Result.fail("请输入验证码");
        }
        String value = (String) redisTemplate.opsForValue().get("captch:" + loginDTO.getCaptchKey());
        if (StringUtils.isBlank(value)){
            return Result.fail("验证码已过期");
        }
        if (!StringUtils.equalsIgnoreCase(value, loginDTO.getCaptchValue())){
            return Result.fail("验证码不正确");
        }
        if (redisTemplate.delete("captch:" + loginDTO.getCaptchKey())) {
            return success(systemService.checkLoginInfo(loginDTO));
        }
        return fail("登录失败，请重试！");
    }

    /**
     * @Author: yongchen
     * @Description: 刷新token
     * @Date: 16:21 2020/8/17
     * @Param: [request]
     * @return: com.example.demo.config.common.rest.Result
     **/
    @GetMapping("/refreshToken")
    @ApiOperation(value = "刷新token", notes = "刷新token")
    public Result refreshToken(HttpServletRequest request){
        String oldToken = request.getHeader(tokenHeader);
        return Result.success(systemService.getRefreshToken(oldToken));
    }

    /**
     * @Author: yongchen
     * @Description: 用户注册
     * @Date: 16:05 2020/8/17
     * @Param: [username, password]
     * @return: com.example.demo.config.common.rest.Result
     **/
    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "用户注册")
    public Result register(@RequestParam String username, @RequestParam String password){
        return Result.success(systemService.register(username, password));
    }

}
