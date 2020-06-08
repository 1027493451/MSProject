//package com.imooc2.product.service;
//
//import com.imooc2.product.common.DecreaseStockInput;
//import com.imooc2.product.dataobject.ProductInfo;
//
//
//import java.util.List;
//
///**
// * @Author snail
// * @Description:
// * @create 2020-03-26 17:19
// * @Version 1.0
// **/
//public interface ProductService {
//    /**
//     * 查询所有在架商品列表
//     */
//    List<ProductInfo> findUpAll();
//
//    /**
//     * 查询商品列表
//     *
//     * @param productIdList
//     * @return
//     */
//    List<ProductInfo> findList(List<String> productIdList);
//
////    /**
////     * 扣库存
////     * @param cartDTOList 购物车信息
////     */
////    void decreaseStock(List<CartDTO> cartDTOList);
//
//
//    /**
//     * 扣库存
//     *
//     * @param decreaseStockInputList 购物车信息
//     */
//    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
//}
