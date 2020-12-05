package com.imooc2.user.role.dao;

import com.imooc2.user.role.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<String> getRoleNameByUserId(Long tuId);
}
