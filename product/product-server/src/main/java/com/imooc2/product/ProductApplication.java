package com.imooc2.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableApi2Doc
//@EnableSwagger2Doc
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.imooc2.product.category.dao"})
public class ProductApplication  {//extends SpringBootServletInitializer

    //修改主方法，添加继承SpringBootServletInitializer并重写
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(ProductApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
