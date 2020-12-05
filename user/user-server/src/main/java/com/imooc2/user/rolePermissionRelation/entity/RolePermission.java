package com.imooc2.user.rolePermissionRelation.entity;

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
@TableName("t_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long trpId;

    private Long roleId;

    private Long permissionId;

    /**
     * 0:可访问，1：可授权
     */
    private Integer permissionType;


}
