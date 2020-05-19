package com.imooc2.order.enums;

import lombok.Getter;

/**
* @description:
* @author: snail
* @create: 14:14 2020/3/27
* @Version: 1.0
**/
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
