package com.imooc2.product.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description:
 * @Author: Snail
 * @Date: 3:06 上午 2020/8/25
 * @Version: 1.0
**/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
