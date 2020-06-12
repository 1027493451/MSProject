package com.imooc2.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-08 15:37
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Configuration
@MapperScan("com.imooc2.product.**.mapper")
public class MybatisPlusConfig {
    /**
     *     分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
