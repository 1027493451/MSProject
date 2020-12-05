package com.imooc2.order.exception;

import com.imooc2.order.enums.ResultEnum;

/**
 * @ClassName OrderException
 * @Description:
 * @Author: Snail
 * @Date: 3:06 上午 2020/8/25
 * @Version: 1.0
**/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
