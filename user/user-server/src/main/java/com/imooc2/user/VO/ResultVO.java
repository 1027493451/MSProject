package com.imooc2.user.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description:
 * @Author: Snail
 * @Date: 3:07 上午 2020/8/25
 * @Version: 1.0
**/
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
