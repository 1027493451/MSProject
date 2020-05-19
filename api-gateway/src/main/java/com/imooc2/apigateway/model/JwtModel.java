package com.imooc2.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-13 16:14
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtModel {
    private String userName;

    private List<String> roleIdList;
}
