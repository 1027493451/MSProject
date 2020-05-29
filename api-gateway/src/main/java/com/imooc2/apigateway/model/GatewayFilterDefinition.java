package com.imooc2.apigateway.model;

//import com.terran4j.commons.api2doc.annotations.ApiComment;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器定义模型
 */
@Data
@Component
public class GatewayFilterDefinition {

    //@ApiComment(value = "路由名字")
    private String name;

    //@ApiComment(value = "对应的路由规则")
    private Map<String, String> args = new LinkedHashMap<>();

}
