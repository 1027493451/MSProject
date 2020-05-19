package com.imooc2.product.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-14 16:45
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("Filter1");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
