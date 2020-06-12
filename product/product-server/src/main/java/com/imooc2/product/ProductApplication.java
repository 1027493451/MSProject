package com.imooc2.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableApi2Doc
//@EnableSwagger2Doc
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.imooc2.product.**.dao")
@EnableTransactionManagement//开启事务支持
public class ProductApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
