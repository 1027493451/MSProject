package com.imooc2.apigateway.controller;

import springfox.documentation.swagger.web.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.Optional;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-29 16:10
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
@RequestMapping("/swagger-resources")
public class SwaggerHandler {
    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;
    @Autowired(required = false)
    private UiConfiguration uiConfiguration;
    private final SwaggerResourcesProvider swaggerResources;

    @Autowired
    public SwaggerHandler(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }


    @GetMapping("/swagger-resources/configuration/security")
    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

    @GetMapping("/swagger-resources/configuration/ui")
    public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity> swaggerResources() {
        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
    }

    @GetMapping("/")
    public Mono<ResponseEntity> swaggerResourcesN() {
        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
    }

    @GetMapping("/csrf")
    public Mono<ResponseEntity> swaggerResourcesCsrf() {
        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
    }

//    private MySwaggerResourceProvider swaggerResourceProvider;
//
//    @Autowired
//    public SwaggerResourceController(MySwaggerResourceProvider swaggerResourceProvider) {
//        this.swaggerResourceProvider = swaggerResourceProvider;
//    }
//
//    @RequestMapping(value = "/configuration/security")
//    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
//        return new ResponseEntity<>(SecurityConfigurationBuilder.builder().build(), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/configuration/ui")
//    public ResponseEntity<UiConfiguration> uiConfiguration() {
//        return new ResponseEntity<>(UiConfigurationBuilder.builder().build(), HttpStatus.OK);
//    }
//
//    @RequestMapping
//    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
//        return new ResponseEntity<>(swaggerResourceProvider.get(), HttpStatus.OK);
//    }
}
