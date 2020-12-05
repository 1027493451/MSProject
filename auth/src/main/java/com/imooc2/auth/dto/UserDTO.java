package com.imooc2.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author snail
 * @Description:
 * @create: 2020-05-13 16:16
 * @Param $
 * @return $
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userName;

    private String password;
}
