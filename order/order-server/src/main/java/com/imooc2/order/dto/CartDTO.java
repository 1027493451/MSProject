package com.imooc2.order.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description:
 * @Author: Snail
 * @Date: 3:05 上午 2020/8/25
 * @Version: 1.0
**/
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
