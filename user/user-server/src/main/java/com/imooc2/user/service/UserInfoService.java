package com.imooc2.user.service;


import com.imooc2.user.dataobject.UserInfo;

/**
 * @Author snail
 * @Description:
 * @create 2020-04-23 16:21
 * @Version 1.0
 **/
public interface UserInfoService {
    /**
     * @param openid
     * @description: 通过openid查找用户
     * @author: snail
     * @create: 16:29 2020/4/23
     * @Version: 1.0
     * @return: com.imooc.user.dataobject.UserInfo
     **/
    UserInfo findByOpenid(String openid);

}
