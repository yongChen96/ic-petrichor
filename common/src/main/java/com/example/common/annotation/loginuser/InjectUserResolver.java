package com.example.common.annotation.loginuser;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: InjectUserResolver
 * @Description: 注解实现类
 * @Author: yongchen
 * @Date: 2020/8/27 11:21
 **/
public class InjectUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class) && methodParameter.hasParameterAnnotation(InjectUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String authorization = request.getHeader("Authorization");
        User user = new User();
        user.setUserId("123456789");
        user.setUserName("admin");
        user.setRoleId("123456789");
        return user;
    }
}
