package com.imooc2.auth.config;


import com.imooc2.auth.component.JwtTokenEnhancer;
import com.imooc2.auth.exception.WebResponseTranslator;
import com.imooc2.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthorizationServerConfig
 * @Description: 认证服务器配置
 * @Author: Snail
 * @Date: 12:22 下午 2020/8/24
 * @Version: 1.0
**/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    //@Qualifier("redisTokenStore")
    @Qualifier(value = "jwtTokenStore")
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;

//    @Autowired(required = true)
//    private AuthorizationCodeServices authorizationCodeServices;


    @Autowired
    private AuthorizationServerTokenServices tokenService;

//    @Autowired
//    @Qualifier("myClientDetailsService")
//    private ClientDetailsService clientService;
//
//    @Bean("myClientDetailsService")
//    public ClientDetailsService clientDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder) {
//        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
//        clientDetailsService.setPasswordEncoder(passwordEncoder);
//        return clientDetailsService;
//    }

    /**
     * 使用密码模式需要配置
     * 令牌访问端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer); //配置JWT的内容增强器
        delegates.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);
//        endpoints.authenticationManager(authenticationManager)
//                .userDetailsService(userService)
//                .tokenStore(tokenStore) //配置令牌存储策略
//                .accessTokenConverter(jwtAccessTokenConverter)
//                .tokenEnhancer(enhancerChain);

        endpoints.authenticationManager(authenticationManager)
                .tokenServices(tokenService)
                .userDetailsService(userService)
                .tokenStore(tokenStore) //配置令牌存储策略
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)
                .exceptionTranslator(new WebResponseTranslator())
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(enhancerChain);


    }

    /**
     * 配置客户端详细信息服务
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
//                .withClient("admin")//配置client_id
//                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
//                .accessTokenValiditySeconds(3600)//配置访问token的有效期
//                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
//                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
//                .scopes("all")//配置申请的权限范围
//                .authorizedGrantTypes("authorization_code","password", "refresh_token");//配置grant_type，表示授权类型

                .withClient("admin")
                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
                .accessTokenValiditySeconds(3600)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
//                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
                .redirectUris("http://localhost:9501/login") //单点登录时配置
                .autoApprove(true) //自动授权配置
                .scopes("all")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token"); //配置grant_type，表示授权类型
    }



    /**
     * 令牌访问端点安全策略
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
        //security.tokenKeyAccess("isAuthenticated()"); // 获取密钥需要身份认证，使用单点登录时必须配置
    }
}
