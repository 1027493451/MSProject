package com.imooc2.apigateway.model;

//import com.terran4j.commons.api2doc.annotations.ApiComment;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 路由断言定义模型
 */
@Data
@Component
public class GatewayPredicateDefinition {

    //@ApiComment(value = "断言对应的Name")
    private String name;

    //@ApiComment(value = "配置的断言规则")
    private Map<String, String> args = new LinkedHashMap<>();

}
