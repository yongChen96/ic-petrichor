package com.petrichor.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.exception.BizException;
import com.petrichor.system.entity.Role;
import com.petrichor.system.entity.SecurityUser;
import com.petrichor.system.entity.User;
import com.petrichor.system.entity.UserRole;
import com.petrichor.system.mapper.UserMapper;
import com.petrichor.system.service.RoleService;
import com.petrichor.system.service.UserRoleService;
import com.petrichor.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, username);
        User user = userService.getOne(queryWrapper);
        if (null == user) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        if ("2".equals(user.getAccStatus())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new BizException("对不起，您的账号：" + username + " 已被注销");
        }
        if ("1".equals(user.getAccStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new BizException("对不起，您的账号：" + username + " 已被冻结");
        }
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole::getUserId, user.getId());
        List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
        List<String> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        List<Role> roles = roleService.listByIds(roleIds);
        return new SecurityUser(user, roles);
    }
}
