package com.example.common.annotation.loginuser;

import java.lang.annotation.*;

/**
 * @ClassName: InjectUser
 * @Description: 用户信息统一采集注解,在api层方法上使用此注解可以获得当前登录用户的信息
 * @Author: yongchen
 * @Date: 2020/8/27 11:02
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectUser {
}
