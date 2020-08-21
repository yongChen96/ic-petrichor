package com.example.common.annotation.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: AnnotaionSysLog
 * @Description: 自定义注解执行器
 * @Author: yongchen
 * @Date: 2020/8/11 10:50
 **/
@Slf4j
@Component
@Aspect
public class AnnotaionSysLog {

    public AnnotaionSysLog(){}

    /**
     * 配置织入点
     **/
    @Pointcut("@annotation(com.example.common.annotation.log.SysLog)")
    public void sysLogAspect() {
    }

//    @Before("sysLogAspect()")
//    public void BeforeSysLog(JoinPoint joinPoint) throws Throwable {
//
//    }

    @AfterReturning(pointcut = "sysLogAspect()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret){
        handleLog(joinPoint, null, ret);
    }

    @AfterThrowing(pointcut = "sysLogAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e){
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        SysLog sysLog = null;
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            sysLog = method.getAnnotation(SysLog.class);
        }

        if (sysLog == null){
            return;
        }

        /*OperateLog operlog = new OperateLog();
        operlog.setStatus(0);

        // 请求的地址
//        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        operlog.setOperateIp("127.0.0.1");
        // 返回参数
        operlog.setJsonResult(JSON.toJSONString(jsonResult));
//        operlog.setOperateUrl(ServletUtils.getRequest().getRequestURI());
        *//*if (loginUser != null) {
            operlog.setOperateName(loginUser.getUsername());
        }*//*
        operlog.setOperateName("admin");
        if (e != null) {
            operlog.setStatus(-1);
            operlog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
        }
        // 设置方法名称
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        operlog.setMethod(className + "." + methodName + "()");
        // 设置请求方式
//        operlog.setRequestMethod(ServletUtils.getRequest().getMethod());
        // 处理设置注解上的参数
        // 设置action动作
        operlog.setBusinessType(0);
        // 设置标题
        operlog.setTitle("123");
        // 设置操作人类别
        operlog.setOperateType(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                logService.insertOperateLog(operlog);
            }
        }).start();*/


    }



}
