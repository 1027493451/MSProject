package com.imooc2.user.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc2.user.role.dao.RoleMapper;
import com.imooc2.user.role.entity.Role;
import com.imooc2.user.role.service.IRoleService;
import com.imooc2.user.rolePermissionRelation.dao.RolePermissionMapper;
import com.imooc2.user.userRoleRelation.dao.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<String> getRoleAndPermissionByUserId(Long tuId) {
        //1.根据用户名查询用户角色关系表中的角色id集合

        //2.根据角色id集合查询角色表中角色名集合并存入list
        List<String> roleNameList=roleMapper.getRoleNameByUserId(tuId);
        //3.根据角色id集合，查询角色权限关系表中权限id的集合

        //4.根据权限id的集合查询权限名集合并存入list
        return roleNameList;
    }
}
