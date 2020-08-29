package com.imooc2.user.role.service;

import com.imooc2.user.role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
public interface IRoleService extends IService<Role> {
    List<String> getRoleAndPermissionByUserId(Long tuId);
}
