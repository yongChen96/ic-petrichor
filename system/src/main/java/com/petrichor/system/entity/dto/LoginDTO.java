package com.petrichor.system.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: LoginDTO
 * @Description: 登录DTO
 * @Author: yongchen
 * @Date: 2020/8/21 15:43
 **/
@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = -7582785959061499719L;

    /**
     * 用户名
     **/
    @NotNull
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     **/
    @NotNull
    @ApiModelProperty(value = "密码")
    private String passWord;

    /**
     * 验证码Key
     **/
    @NotNull
    @ApiModelProperty(value = "验证码Key")
    private String captchKey;

    /**
     * 验证码值
     **/
    @NotNull
    @ApiModelProperty(value = "验证码值")
    private String captchValue;

}
