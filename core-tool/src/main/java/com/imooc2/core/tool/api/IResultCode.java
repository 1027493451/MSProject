package com.imooc2.core.tool.api;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-09 17:16
 * @Param $
 * @return $
 * @Version 1.0
 **/
import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}

