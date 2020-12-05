package com.imooc2.product.category.service;

import com.imooc2.product.category.entity.ProductCategory;
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
public interface IProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
