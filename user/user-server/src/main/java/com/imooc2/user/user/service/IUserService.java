package com.imooc2.user.user.service;

import com.imooc2.user.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
public interface IUserService extends IService<User> {

    User getTbUserByUserName(String username);
}
