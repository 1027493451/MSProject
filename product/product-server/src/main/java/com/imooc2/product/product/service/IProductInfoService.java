package com.imooc2.product.product.service;

import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.product.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
public interface IProductInfoService extends IService<ProductInfo> {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

//    /**
//     * 扣库存
//     * @param cartDTOList 购物车信息
//     */
//    void decreaseStock(List<CartDTO> cartDTOList);


    /**
     * 扣库存
     *
     * @param decreaseStockInputList 购物车信息
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
