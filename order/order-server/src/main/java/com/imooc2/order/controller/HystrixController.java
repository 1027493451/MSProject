package com.imooc2.order.controller;


import com.imooc2.order.utils.RestTemplateUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author snail
 * @Description: 降级服务
 * @create: 2020-04-29 15:10
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //自定义服务降级
    //@HystrixCommand(fallbackMethod = "fallback")
    //使用默认defaultFallback的服务降级
//    @HystrixCommand(commandProperties = {
//            //服务接口超时设置
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000") //访问接口超过3S,就触发服务降级，默认是超过1S触发服务降级
//    })
    //熔断机制
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="circuitBreaker.enabled",value="true"), //打开熔断器
//            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
//            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"), //熔断器打开时间，10S后进入半开状态
//            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"), //错误率为百分之60以上触发熔断
//    })
    @HystrixCommand //超时设置设置到配置文件
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(HttpServletRequest req, @RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("form", "gateway");

        //RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
        HttpEntity<List<String>> entity = new HttpEntity<>(Arrays.asList("1"), headers);

        //RestTemplate restTemplate=new RestTemplate();
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
        return restTemplate.postForObject("http://localhost:8085/product/listForOrder",
                req,
                String.class);
//        return restTemplate.postForObject("http://localhost:8085/product/listForOrder",
//                Arrays.asList("1"),
//                String.class);
//        throw new RuntimeException("发生异常，触发降级");
    }

    private String fallback() {
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback() {
        return "默认设置：太拥挤了，请稍后再试";
    }
}
