package com.imooc2.product.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-30 09:53
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
public class ServerController {
    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }
}
