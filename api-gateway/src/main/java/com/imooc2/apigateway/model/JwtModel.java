package com.imooc2.apigateway.model;

//import com.terran4j.commons.api2doc.annotations.ApiComment;

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

    //@ApiComment(value = "用户名")
    private String userName;

    //@ApiComment(value = "角色列表")
    private List<String> roleIdList;
}
