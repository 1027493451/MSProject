package com.imooc2.product.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-10 16:55
 * @Param $
 * @return $
 * @Version 1.0
 **/
//@MapperScan(basePackages = "com.imooc2.product.**.dao")
@Configuration
@PropertySource(value = "classpath:config/druid-monitor.properties")
@ConfigurationProperties
public class DruidMonitorConfiguration {

    @Value("${druid.monitor.allow:127.0.0.1}")
    private String allow;
    @Value("${druid.monitor.deny}")
    private String deny;
    @Value("${druid.monitor.loginUsername:admin}")
    private String loginUsername;
    @Value("${druid.monitor.loginPassword:password}")
    private String loginPassword;
    @Value("${druid.monitor.resetEnable:false}")
    private String resetEnable;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("allow", this.allow);
        servletRegistrationBean.addInitParameter("deny", this.deny);
        servletRegistrationBean.addInitParameter("loginUsername", this.loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", this.loginPassword);
        servletRegistrationBean.addInitParameter("resetEnable", this.resetEnable);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
