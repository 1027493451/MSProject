package com.imooc2.product.service.Impl;


import com.imooc2.product.dataobject.ProductCategory;
import com.imooc2.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imooc2.product.service.CategoryService;

import java.util.List;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-26 17:31
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
