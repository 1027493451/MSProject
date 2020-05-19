package com.imooc2.product.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//@Table(name="product_info")
@Data
@Entity
public class ProductInfo {


    public ProductInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;

    /**
     * 名字.
     */
    @Column
    private String productName;

    /**
     * 单价.
     */
    @Column
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    @Column
    private Integer productStock;

    /**
     * 描述.
     */
    @Column
    private String productDescription;

    /**
     * 小图.
     */
    @Column
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     */
    @Column
    private Integer productStatus;

    /**
     * 类目编号.
     */
    @Column
    private Integer categoryType;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;
}
