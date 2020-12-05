package com.imooc2.product.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "DecreaseStockInput",description="扣库存输入类")
public class DecreaseStockInput {
    @ApiModelProperty(value="商品id",dataType ="String",required = true)
    private String productId;

    @ApiModelProperty(value="扣除商品的数量",dataType ="Integer" ,required = true)
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
