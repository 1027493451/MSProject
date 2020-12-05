package com.imooc2.apigateway.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description: http请求返回的最外层对象
 * @Author: Snail
 * @Date: 3:04 上午 2020/8/25
 * @Version: 1.0
**/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
