package com.imooc2.product.DTO;

import lombok.Data;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-30 17:40
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Data
public class CartDTO {
    private String productId;  //商品id
    private Integer productQuantity;//购买的商品数量
}
