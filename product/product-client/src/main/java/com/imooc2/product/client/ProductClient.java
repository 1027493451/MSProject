package com.imooc2.product.client;


import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-30 11:53
 * @Param $
 * @return $
 * @Version 1.0
 **/
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    /**
     * @param
     * @description: 触发服务降级回调函数实现
     * @author: snail
     * @create: 17:32 2020/4/30
     * @Version: 1.0
     * @return:
     **/
    @Component
    static class ProductClientFallback implements ProductClient {

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }
    }
}
