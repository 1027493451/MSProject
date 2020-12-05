package com.imooc2.product.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName JsonUtil
 * @Description:
 * @Author: Snail
 * @Date: 3:07 上午 2020/8/25
 * @Version: 1.0
**/
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
