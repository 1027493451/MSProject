package com.imooc2.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName JwtTokenStoreConfig
 * @Description: JWT增强器
 * @Author: Snail
 * @Date: 3:02 上午 2020/8/25
 * @Version: 1.0
**/
@Configuration
public class JwtTokenStoreConfig {
    /**
     * 秘钥串
     */
    private static final String SIGNING_KEY = "auth";


    @Primary
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}

