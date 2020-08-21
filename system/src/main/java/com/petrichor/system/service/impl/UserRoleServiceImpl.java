package com.petrichor.system.service.impl;

import com.petrichor.system.entity.UserRole;
import com.petrichor.system.mapper.UserRoleMapper;
import com.petrichor.system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
