package com.imooc2.product.repository;


import com.imooc2.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    //findByProductStatus要符合JpaRepository的自定义接口命名规则
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    Optional<ProductInfo> findById(String productId);

    ProductInfo findByProductId(String productId);
}
