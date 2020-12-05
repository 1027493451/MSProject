package com.imooc2.user.userRoleRelation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Snail
 * @since 2020-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long turId;

    private Long tuId;

    private Long trId;


}
