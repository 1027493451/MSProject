package com.imooc2.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-01 09:43
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Configuration
public class RateLimiterConfiguration {
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
