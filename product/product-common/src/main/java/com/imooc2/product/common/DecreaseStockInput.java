package com.imooc2.product.common;

import lombok.Data;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-31 17:26
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
