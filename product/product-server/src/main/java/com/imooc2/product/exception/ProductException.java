package com.imooc2.product.exception;


import com.imooc2.product.enums.ResultEnum;

/**
 * @ClassName ProductException
 * @Description:
 * @Author: Snail
 * @Date: 3:07 上午 2020/8/25
 * @Version: 1.0
**/
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
