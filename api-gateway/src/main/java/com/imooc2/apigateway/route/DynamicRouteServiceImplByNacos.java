package com.imooc2.apigateway.route;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.imooc2.apigateway.model.NacosGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

@Component
@RefreshScope
public class DynamicRouteServiceImplByNacos {

    private static Logger logger = LoggerFactory.getLogger(DynamicRouteServiceImplByNacos.class);


    @Autowired
    private NacosGatewayProperties nacosGatewayProperties;

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Bean
    public String routeServiceInit() {
        dynamicRouteByNacosListener();
        return "success";
    }


    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener() {
        try {
            ConfigService configService = NacosFactory.createConfigService(nacosGatewayProperties.getServerAddr());
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroup(), nacosGatewayProperties.getTimeout());
            logger.info("nacos初始化监听,{}", content);
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroup(), new Listener() {

                @Override
                public void receiveConfigInfo(String configInfo) {
                    try {
                        List<RouteDefinition> gatewayRouteDefinitions = JSONObject.parseArray(configInfo, RouteDefinition.class);
                        for (RouteDefinition routeDefinition : gatewayRouteDefinitions) {
                            logger.info("遍历:" + routeDefinition.toString());
                            dynamicRouteService.update(routeDefinition);
                        }
                    } catch (Exception e) {
                        logger.error("更新配置出错:", e);
                    }
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            logger.error("初始化nacos监听出错:", e);
        }
    }

}
