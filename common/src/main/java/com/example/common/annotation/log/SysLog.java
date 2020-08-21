package com.example.common.annotation.log;

import java.lang.annotation.*;

/**
 * @ClassName: SysLog
 * @Description: 系统操作日志自定义注解
 * @Author: yongchen
 * @Date: 2020/8/19 15:39
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value();
}
