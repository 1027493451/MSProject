package com.imooc2.product.product.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;

    private Integer categoryType;

    private Date createTime;

    private String productDescription;

    private String productIcon;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStatus;

    private Integer productStock;

    private Date updateTime;


}
