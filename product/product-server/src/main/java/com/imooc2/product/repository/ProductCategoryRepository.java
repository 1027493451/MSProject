package com.imooc2.product.repository;


import com.imooc2.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
