package com.imooc2.apigateway.model;


//import com.terran4j.commons.api2doc.annotations.ApiComment;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Gateway的路由定义模型
 */
@Data
@Component
public class GatewayRouteDefinition {

    //@ApiComment(value = "路由的Id")
    private String id;

    //@ApiComment(value = "路由断言集合配置")
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();

    //@ApiComment(value = "路由过滤器集合配置")
    private List<GatewayFilterDefinition> filters = new ArrayList<>();

    //@ApiComment(value = "路由规则转发的目标uri")
    private String uri;

    //@ApiComment(value = "路由执行的顺序")
    private int order = 0;
}
