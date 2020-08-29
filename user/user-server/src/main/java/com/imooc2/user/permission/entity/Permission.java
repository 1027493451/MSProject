package com.imooc2.user.permission.entity;

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
@TableName("t_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tpId;

    private Integer parentId;

    private String tpName;


}
