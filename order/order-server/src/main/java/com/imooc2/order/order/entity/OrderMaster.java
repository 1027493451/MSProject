package com.imooc2.order.order.entity;

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
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    private String buyerAddress;

    private String buyerName;

    private String buyerOpenid;

    private String buyerPhone;

    private Date createTime;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date updateTime;


}
