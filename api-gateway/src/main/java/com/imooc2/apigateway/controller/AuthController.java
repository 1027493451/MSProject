package com.imooc2.apigateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc2.apigateway.VO.ResultVO;
import com.imooc2.apigateway.dto.UserDTO;
import com.imooc2.apigateway.model.JwtModel;
import com.imooc2.apigateway.util.JwtUtil;
//import com.terran4j.commons.api2doc.annotations.Api2Doc;
//import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    private ObjectMapper objectMapper;

    @Value("${org.my.jwt.effective-time}")
    private String effectiveTime;

    public AuthController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 登陆认证接口
     *
     * @param userDTO
     * @return
     */
    //@ApiComment("登陆认证接口")
    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody UserDTO userDTO) throws Exception {
        ArrayList<String> roleIdList = new ArrayList<>(1);
        roleIdList.add("role_test_1");
        JwtModel jwtModel = new JwtModel("test", roleIdList);
        int effectivTimeInt = Integer.valueOf(effectiveTime.substring(0, effectiveTime.length() - 1));
        String effectivTimeUnit = effectiveTime.substring(effectiveTime.length() - 1, effectiveTime.length());
        String jwt = null;
        switch (effectivTimeUnit) {
            case "s": {
                //秒
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 1000L);
                break;
            }
            case "m": {
                //分钟
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 60L * 1000L);
                break;
            }
            case "h": {
                //小时
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 60L * 60L * 1000L);
                break;
            }
            case "d": {
                //小时
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 24L * 60L * 60L * 1000L);
                break;
            }
        }
        return new ResultVO<String>(HttpStatus.OK.value(), "认证成功", jwt);
    }
}
