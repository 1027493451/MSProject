package com.imooc2.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-01 16:55
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {
    private String name;

    private Integer age;

}
