package com.imooc2.product.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author snail
 * @Description: filter过滤器，用于拦截不经过网关调用接口
 * @create: 2020-05-14 16:44
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Order(1)
@WebFilter(filterName = "myFilter1",urlPatterns = {"/*"})
public class MyFilter implements Filter {


    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //解决跨域的问题
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");


        String secretKey = request.getHeader("from");
//        if(!(StringUtils.isNotBlank(secretKey)&&secretKey.equals("gateway"))){
//            response.setContentType("application/json; charset=utf-8");
//            Map<String, String> map = new HashMap<>();
//            map.put("code", "9999");
//            map.put("msg", "没有访问权限，如需要访问，请联系管理员!");
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().print(JSONObject.toJSON(map));
//            return ;
//            //throw new AuthenticationException("token认证失败");
//        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}
