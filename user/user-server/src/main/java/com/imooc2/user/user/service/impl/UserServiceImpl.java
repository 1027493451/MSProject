package com.imooc2.user.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc2.user.user.dao.UserMapper;
import com.imooc2.user.user.entity.User;
import com.imooc2.user.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getTbUserByUserName(String username) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.lambda().eq(User::getUsername,username);
        return userMapper.selectOne(queryWrapper);
    }
}
