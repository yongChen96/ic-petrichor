package com.petrichor.system.service.impl;

import com.petrichor.system.entity.Role;
import com.petrichor.system.mapper.RoleMapper;
import com.petrichor.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
