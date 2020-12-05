package com.imooc2.apigateway.utils;


import com.imooc2.apigateway.VO.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Description:
 * @Author: Snail
 * @Date: 3:10 上午 2020/8/25
 * @Version: 1.0
**/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
