//package com.imooc2.product.dataobject;
//
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//
////@Table(name="product_info")
//@Data
//@Entity
//public class ProductInfo {
//
//
//    public ProductInfo() {
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ApiModelProperty("商品id")
//    private String productId;
//
//    /**
//     * 名字.
//     */
//    @Column
//    @ApiModelProperty("商品名字")
//    private String productName;
//
//    /**
//     * 单价.
//     */
//    @Column
//    @ApiModelProperty("单价")
//    private BigDecimal productPrice;
//
//    /**
//     * 库存.
//     */
//    @Column
//    @ApiModelProperty("库存")
//    private Integer productStock;
//
//    /**
//     * 描述.
//     */
//    @Column
//    @ApiModelProperty("描述")
//    private String productDescription;
//
//    /**
//     * 小图.
//     */
//    @Column
//    @ApiModelProperty("小图")
//    private String productIcon;
//
//    /**
//     * 状态, 0正常1下架.
//     */
//    @Column
//    @ApiModelProperty("状态")
//    private Integer productStatus;
//
//    /**
//     * 类目编号.
//     */
//    @Column
//    @ApiModelProperty("类目编号")
//    private Integer categoryType;
//
//    @Column
//    @ApiModelProperty("创建时间")
//    private Date createTime;
//
//    @Column
//    @ApiModelProperty("更新时间")
//    private Date updateTime;
//}
