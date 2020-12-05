package com.imooc2.util.utils;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-09 17:17
 * @Param $
 * @return $
 * @Version 1.0
 **/
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

public class ObjectUtil extends ObjectUtils {
    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}
