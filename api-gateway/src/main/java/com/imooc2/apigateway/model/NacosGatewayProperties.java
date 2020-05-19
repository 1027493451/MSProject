package com.imooc2.apigateway.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author snail
 * @Description: 获取nacos 配置参数
 * @create: 2020-05-12 16:50
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix="nacos")
public class NacosGatewayProperties {

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;

    private String dataId;

    private String group;

    @Value("${spring.cloud.nacos.config.timeout}")
    private Long timeout;

}