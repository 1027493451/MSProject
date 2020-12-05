package com.imooc2.order.enums;

import lombok.Getter;

/**
 * @description:
 * @author: snail
 * @create: 14:14 2020/3/27
 * @Version: 1.0
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
