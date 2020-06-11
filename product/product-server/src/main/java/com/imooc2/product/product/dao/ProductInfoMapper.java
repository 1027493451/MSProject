package com.imooc2.product.product.dao;

import com.imooc2.product.product.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> findList(@Param(value = "productIdList") List<String> productIdList);

}
