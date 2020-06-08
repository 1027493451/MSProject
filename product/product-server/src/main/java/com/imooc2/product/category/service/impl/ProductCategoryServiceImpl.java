package com.imooc2.product.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc2.product.category.entity.ProductCategory;
import com.imooc2.product.category.dao.ProductCategoryMapper;
import com.imooc2.product.category.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {


    @Resource
    @Autowired
    private ProductCategoryMapper productCategoryMapper;


    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        QueryWrapper<ProductCategory> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().in(ProductCategory::getCategoryType,categoryTypeList);
        return productCategoryMapper.selectList(queryWrapper);
        //return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        //return null;
    }
}
