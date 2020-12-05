package com.imooc2.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @ClassName CustomOauthException
 * @Description:
 * @Author: Snail
 * @Date: 12:24 下午 2020/8/24
 * @Version: 1.0
**/
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    public CustomOauthException(String msg) {
        super(msg);
    }
}
