package com.imooc2.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


//import com.terran4j.commons.api2doc.annotations.Api2Doc;
//import com.terran4j.commons.api2doc.annotations.ApiComment;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-13 15:10
 * @Param $
 * @return $
 * @Version 1.0
 **/
//@Api2Doc(id = "auth", name = "权限接口")
//@ApiComment(seeClass = AuthController.class)
@Api(value = "用户接口服务", description = "用户接口服务")
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Value("${org.my.jwt.effective-time}")
//    private String effectiveTime;
//
//    @GetMapping("/msg")
//    public String msg(){
//        return "msg";
//    }

    @ApiOperation(value = "查询通过 OAuth2.0 授权后获取的用户信息", notes = "通过 OAuth2.0 授权后获取的用户信息")
    @GetMapping("/principal")
    public Principal principal(Principal principal)
    {
        return principal;
    }
}
