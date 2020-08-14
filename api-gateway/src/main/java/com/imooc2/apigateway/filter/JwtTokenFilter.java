package com.imooc2.apigateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc2.apigateway.VO.ResultVO;
import com.imooc2.apigateway.util.EncryptUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-13 15:13
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Component
//读取 yml 文件下的 org.my.jwt
@ConfigurationProperties("org.my.jwt")
@Data
@Slf4j
public class JwtTokenFilter implements GlobalFilter, Ordered {

    private String[] skipAuthUrls;

    private ObjectMapper objectMapper;

    @Autowired
    private TokenStore tokenStore;

    public JwtTokenFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 过滤器
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        AntPathMatcher pathMatcher = new AntPathMatcher();

        if (pathMatcher.match("/auth/**", url)) {
            return chain.filter(exchange);
        }
        //跳过不需要验证的路径
        if (null != skipAuthUrls && Arrays.asList(skipAuthUrls).contains(url)) {
            return chain.filter(exchange);
        }
        //2 从request获取token
        String token = getToken(exchange);
        ServerHttpResponse resp = exchange.getResponse();
        if (StringUtils.isBlank(token)) {
            //没有token
            return authErro(resp, "请登陆");
        } else {
            OAuth2AccessToken oAuth2AccessToken;
            try {
                oAuth2AccessToken = tokenStore.readAccessToken(token);
                Map<String, Object> additionalInformation = oAuth2AccessToken.getAdditionalInformation();
                //取出用户身份信息
                String principal = MapUtils.getString(additionalInformation, "user_name");
                //获取用户权限
                List<String> authorities = (List<String>) additionalInformation.get("authorities");
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("principal",principal);
                jsonObject.put("authorities",authorities);
                //给header里面添加值
                String base64 = EncryptUtil.encodeUTF8StringBase64(jsonObject.toJSONString());
                ServerHttpRequest tokenRequest = exchange.getRequest().mutate().header("json-token", base64).header("from", "gateway").build();
                ServerWebExchange build = exchange.mutate().request(tokenRequest).build();
                return chain.filter(build);//跳到下一个过滤器
            } catch (InvalidTokenException e) {
                log.info("无效的token: {}", token);
                return authErro(resp, "无效的token");
            }
        }
    }

    /**
     * 认证错误输出
     *
     * @param resp 响应对象
     * @param mess 错误信息
     * @return
     */
    private Mono<Void> authErro(ServerHttpResponse resp, String mess) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        ResultVO<String> returnData = new ResultVO<>(HttpStatus.UNAUTHORIZED.value(), mess, mess);
        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(returnData);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return -100;
    }

    /**
     * 从request获取token
     */
    private String getToken(ServerWebExchange exchange) {
        //获取token
        String tokenStr = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StringUtils.isBlank(tokenStr)) {
            return null;
        }
        String token = tokenStr.split(" ")[1];
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return token;
    }
}

