package com.example.security.loginuser;

import com.example.security.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: InjectUserResolver
 * @Description: 注解实现类
 * @Author: yongchen
 * @Date: 2020/8/27 11:21
 **/
@Slf4j
public class InjectUserResolver implements HandlerMethodArgumentResolver {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class) && methodParameter.hasParameterAnnotation(InjectUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(this.tokenHead.length());
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            log.info("checking username:{}", username);
            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                return userDetails;
            }
        }
        return null;
    }
}
