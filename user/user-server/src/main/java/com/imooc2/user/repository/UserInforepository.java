package com.imooc2.user.repository;


import com.imooc2.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 16:26
 * @Param $
 * @return $
 * @Version 1.0
 **/
public interface UserInforepository extends JpaRepository<UserInfo, String> {
    UserInfo findByOpenid(String openid);
}
