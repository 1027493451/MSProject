package com.imooc2.user.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc2.user.permission.dao.PermissionMapper;
import com.imooc2.user.permission.entity.Permission;
import com.imooc2.user.permission.service.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
