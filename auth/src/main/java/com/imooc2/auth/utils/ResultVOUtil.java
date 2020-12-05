package com.imooc2.auth.utils;


import com.imooc2.auth.VO.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Description:
 * @Author: Snail
 * @Date: 2:52 上午 2020/8/25
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
