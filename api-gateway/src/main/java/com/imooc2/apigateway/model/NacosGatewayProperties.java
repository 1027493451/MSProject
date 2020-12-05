package com.imooc2.apigateway.model;


//import com.terran4j.commons.api2doc.annotations.ApiComment;

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
@ConfigurationProperties(prefix = "nacos")
public class NacosGatewayProperties {

    //@ApiComment(value = "nacos服务ip地址")
    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;

    //@ApiComment(value = "nacos服务里配置文件id")
    private String dataId;

    //@ApiComment(value = "nacos服务里配置文件分组")
    private String group;

    //@ApiComment(value = "nacos超时设置，默认5000（5秒）")
    @Value("${spring.cloud.nacos.config.timeout}")
    private Long timeout;

}