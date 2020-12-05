package com.imooc2.order.utils;

import com.imooc2.order.VO.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Description:
 * @Author: Snail
 * @Date: 3:06 上午 2020/8/25
 * @Version: 1.0
**/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
