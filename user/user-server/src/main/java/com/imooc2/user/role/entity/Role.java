package com.imooc2.user.role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Snail
 * @since 2020-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trId;

    private String roleName;


}
