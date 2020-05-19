package com.imooc2.product.filter;

import com.google.common.base.Strings;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author snail
 * @Description: 自定义返回过滤器异常的格式
 * @create: 2020-05-14 17:21
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
public class ErrorController extends BasicErrorController {
    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
//
//        R ret = R.error(status.value(), body.get("message").toString());
//        //TokenException Filter抛出的自定义错误类
//        if (!Strings.isNullOrEmpty((String) body.get("exception")) && body.get("exception").equals(TokenException.class.getName())) {
//            body.put("status", HttpStatus.FORBIDDEN.value());
//            status = HttpStatus.FORBIDDEN;
//
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",body.get("status"));
        map.put("msg",body.get("message"));
        return new ResponseEntity<Map<String, Object>>(map, status);
    }
}
