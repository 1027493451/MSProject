package com.imooc2.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductVO
 * @Description:
 * @Author: Snail
 * @Date: 3:06 上午 2020/8/25
 * @Version: 1.0
**/
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
