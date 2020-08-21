package com.petrichor.system.mapper;

import com.petrichor.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author yongchen
 * @since 2020-08-20
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
