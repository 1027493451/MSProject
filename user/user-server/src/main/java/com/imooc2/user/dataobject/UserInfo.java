package com.imooc2.user.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-23 16:12
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
@Entity
public class UserInfo {

    @Id
    private String id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String openid;
    @Column
    private Integer role;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}
