package com.imooc2.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ProductApplication extends SpringBootServletInitializer {

    //修改主方法，添加继承SpringBootServletInitializer并重写
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProductApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
