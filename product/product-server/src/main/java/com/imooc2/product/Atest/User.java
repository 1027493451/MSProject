package com.imooc2.product.Atest;

import java.util.Date;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.terran4j.commons.restpack.RestPackIgnore;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class User {
    @ApiComment(value = "用户id", sample = "123")
    private Long id;

    @ApiComment(value = "用户名", sample = "terran4j")
    private String name;

    @ApiComment(value = "账号密码,字母与数字的组合,区分大小写，8-12位", sample = "sdfi23skvs")
    private String password;

    @ApiComment(value = "用户所在的部门", sample = "研发组")
    private String dept;

    @ApiComment(value = "用户类型", sample = "admin")
    private UserType type;

    @ApiComment(value = "是否已删除", sample = "true")
    @RestPackIgnore
    private Boolean deleted;

    @ApiComment(value = "创建时间,也是注册时间。", sample = "2018-12-12")
    private Date createTime;
}
