package com.imooc2.auth.config;

import com.imooc2.auth.handler.FailureHandler;
import com.imooc2.auth.handler.LogoutHandler;
import com.imooc2.auth.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @ClassName SecurityConfig
 * @Description:
 * @Author: suxijiang
 * @Date: 5:40 下午 2020/8/19
 * @Version: 1.0
**/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启权限控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/**", "/login/**", "/logout/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
        http.csrf().disable().formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(successHandler).permitAll()
                .failureHandler(failureHandler).permitAll().and()
                .logout().logoutSuccessHandler(logoutHandler).and()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}

