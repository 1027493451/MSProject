package com.imooc2.auth.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @ClassName Snail
 * @Description:
 * @Author: suxijiang
 * @Date: 6:19 下午 2020/8/19
 * @Version: 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // @Value("${config.oauth2.accessTokenUri}")
    //private String accessTokenUri ="http://localhost:3000/oauth/token";
    private String accessTokenUri ="http://localhost:9000/auth/oauth/token";


    @Bean
    public Docket docker() {
        // 构造函数传入初始化规范，这是swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                .apiInfo(apiInfo())
                .groupName("auth")
                //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                .enable(true)
                .select()
                //apis： 添加过滤条件,
                .apis(RequestHandlerSelectors.basePackage("com.imooc2.auth.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//过滤：只显示有@ApiOperation注解的方法
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiImplicitParam.class))//过滤：只显示有@ApiImplicitParam注解的方法
                //paths： 这里是控制哪些路径的api会被显示出来，比如下方的参数就是除了/user以外的其它路径都会生成api文档
                .paths(PathSelectors.any())
//                .paths((String a) ->
//                        !a.equals("/user"))
                .build()
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Arrays.asList(securitySchema()));
                //.securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey()));
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("sxj", "http://www.sxj.com/", "1027493451@qq.com");
        return new ApiInfo(
                "商品模块Api接口", // 标题
                "商品的CRBD", // 描述
                "1.0", // 版本
                "链接：http://wwww.baidu.com/", //这里配置的是服务网站
                contact, // 联系人信息
                "许可：sxj 1.0 ", // 许可
                "许可链接：http://wwww.baidu.com/", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    @Bean
    public SecurityScheme apiKey() {
        return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
    }

    @Bean
    public SecurityScheme apiCookieKey() {
        return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
    }

    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = newArrayList();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));
        List<GrantType> grantTypes = newArrayList();
        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
        grantTypes.add(passwordCredentialsGrant);

        return new OAuth("oauth2", authorizationScopeList, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
    }

//    @Bean
//    public SecurityConfiguration security() {
//        return new SecurityConfiguration
//                ("client", "secret", "", "", "Bearer access token", ApiKeyVehicle.HEADER, HttpHeaders.AUTHORIZATION,"");
//    }

    @Bean
    SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId("client_test")
                .clientSecret("secret_test")
                .realm("test-app-realm")
                .appName("test-app")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .validatorUrl(null)
                .build();
    }

}
