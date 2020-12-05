package com.imooc2.user.controller;


import com.imooc2.user.Constant.CookieConstant;
import com.imooc2.user.RedisConstant.RedisConstant;
import com.imooc2.user.VO.ResultVO;
import com.imooc2.user.dataobject.UserInfo;
import com.imooc2.user.enums.ResultEnum;
import com.imooc2.user.enums.RoleEnum;
import com.imooc2.user.service.UserInfoService;
import com.imooc2.user.utils.CookieUtil;
import com.imooc2.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 16:31
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @param openid
     * @param response
     * @description: 买家登陆
     * @author: snail
     * @create: 16:40 2020/4/23
     * @Version: 1.0
     * @return: com.imooc.user.VO.ResultVO
     **/
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam String openid, HttpServletResponse response) {
        //1. openid和数据库的数据匹配
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
        //2.判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.cookid里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.exipre);
        return ResultVOUtil.success();
    }

    /**
     * @param openid
     * @param response
     * @description: 卖家登陆
     * @author: snail
     * @create: 16:40 2020/4/23
     * @Version: 1.0
     * @return: com.imooc.user.VO.ResultVO
     **/
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam String openid, HttpServletResponse response, HttpServletRequest request) {
        //判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TRMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        //1. openid和数据库的数据匹配
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
        //2.判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3.redis设置key=uuid,value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.exipre;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TRMPLATE, token), openid, expire, TimeUnit.SECONDS);

        //4.cookid里设置openid=abc
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.exipre);
        return ResultVOUtil.success();
    }

}
