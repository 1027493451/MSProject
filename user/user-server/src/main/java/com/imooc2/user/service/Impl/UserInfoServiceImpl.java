package com.imooc2.user.service.Impl;


import com.imooc2.user.dataobject.UserInfo;
import com.imooc2.user.repository.UserInforepository;
import com.imooc2.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 16:22
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInforepository userInforepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInforepository.findByOpenid(openid);
    }
}
