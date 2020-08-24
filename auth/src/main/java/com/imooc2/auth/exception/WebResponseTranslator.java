package com.imooc2.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;


/**
 * @ClassName WebResponseTranslator
 * @Description:
 * @Author: Snail
 * @Date: 12:24 下午 2020/8/24
 * @Version: 1.0
**/
public class WebResponseTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception exception) throws Exception {
        if (exception instanceof InternalAuthenticationServiceException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CustomOauthException("账号密码错误"));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CustomOauthException(exception.getMessage()));
    }
}
