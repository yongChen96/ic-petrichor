package com.petrichor.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.exception.BizException;
import com.example.common.restful.Result;
import com.example.security.utils.JwtTokenUtil;
import com.petrichor.system.entity.Role;
import com.petrichor.system.entity.User;
import com.petrichor.system.entity.UserRole;
import com.petrichor.system.entity.dto.LoginDTO;
import com.petrichor.system.entity.SecurityUser;
import com.petrichor.system.service.RoleService;
import com.petrichor.system.service.SystemService;
import com.petrichor.system.service.UserRoleService;
import com.petrichor.system.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: SystemServiceImpl
 * @Description: 登录注册服务实现
 * @Author: yongchen
 * @Date: 2020/8/21 15:49
 **/
@Service
public class SystemServiceImpl implements SystemService {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;


    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public Map<String, Object> checkLoginInfo(LoginDTO loginDTO) {
        HashMap<String, Object> restMap = new HashMap<>();
        UserDetails userDetails = userService.loadUserByUsername(loginDTO.getUserName());
        if(!passwordEncoder.matches(loginDTO.getPassWord(),userDetails.getPassword())){
            throw new BizException("密码不正确");
        }
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> map = new HashMap<>();
        map.put("tokenHead",tokenHead);
        map.put("token",token);
        restMap.put("token",map);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, loginDTO.getUserName());
        User user = userService.getOne(queryWrapper);
        restMap.put("user",user);
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole::getUserId, user.getId());
        List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
        List<String> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        List<Role> roles = roleService.listByIds(roleIds);
        restMap.put("roles",roles);
        return restMap;
    }

    /**
     * @Author: yongchen
     * @Description: 用户注册
     * @Date: 16:26 2020/8/21
     * @Param: [username, password]
     * @return: java.lang.Boolean
     **/
    @Override
    public Boolean register(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setNickName(username);
        //密码加密
        user.setPassword(passwordEncoder.encode(password));
        user.setAccStatus("0");
        user.setDelState("0");
        if (userService.save(user)){
            return true;
        }
        return false;
    }

    /**
     * @Author: yongchen
     * @Description: 获取刷新Token
     * @Date: 16:23 2020/8/21
     * @Param: [oldToken]
     * @return: java.util.Map<java.lang.String,java.lang.String>
     **/
    @Override
    public Map<String, String> getRefreshToken(String oldToken) {
        String refreshToken = jwtTokenUtil.refreshHeadToken(oldToken);
        if (refreshToken == null) {
            throw new BizException("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return tokenMap;
    }
}
