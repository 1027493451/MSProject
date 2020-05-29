package com.imooc2.user.enums;

import lombok.Getter;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 17:28
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
