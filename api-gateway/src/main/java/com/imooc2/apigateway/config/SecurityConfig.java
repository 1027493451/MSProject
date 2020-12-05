package com.imooc2.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Description: 网关的security做权限认证
 * @Author: snail
 * @Date: 2020/7/18 13:21
 */
@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/user/**").hasRole("ADMIN")
                .pathMatchers("/order/**").hasRole("USER")
                .pathMatchers("/product/**").hasRole("USER")
                .pathMatchers("/**").permitAll()
                .anyExchange()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .build();
    }


}