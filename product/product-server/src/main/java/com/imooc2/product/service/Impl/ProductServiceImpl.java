//package com.imooc2.product.service.Impl;
//
//import com.imooc2.product.common.DecreaseStockInput;
//import com.imooc2.product.common.ProductInfoOutput;
//import com.imooc2.product.dataobject.ProductInfo;
//import com.imooc2.product.enums.ResultEnum;
//import com.imooc2.product.exception.ProductException;
//import com.imooc2.product.service.ProductService;
//import com.imooc2.product.utils.JsonUtil;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.imooc2.product.enums.ProductStatusEnum;
//import com.imooc2.product.repository.ProductInfoRepository;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
///**
// * @Author snail
// * @Description:
// * @create: 2020-03-26 17:25
// * @Version 1.0
// **/
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    @Autowired
//    private ProductInfoRepository productInfoRepository;
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Override
//    public List<ProductInfo> findUpAll() {
//        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
//    }
//
//    @Override
//    public List<ProductInfo> findList(List<String> productIdList) {
//        //线程睡眠两秒后在运行，用于测试服务降价和超时设置
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        return productInfoRepository.findByProductIdIn(productIdList);
//    }
//
//    @Override
//    @Transactional
//    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
//        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
//        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
//            ProductInfoOutput output = new ProductInfoOutput();
//            BeanUtils.copyProperties(e, output);
//            return output;
//        }).collect(Collectors.toList());
//
//        //发送MQ消息
//        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));
//    }
//
//    @Transactional
//    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
//
//        List<ProductInfo> productInfoList = new ArrayList<>();
//        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList
//        ) {
//            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
//            if (!productInfoOptional.isPresent()) {
//                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
//            }
//            ProductInfo productInfo = productInfoOptional.get();
//            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
//            if (result < 0) {
//                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
//            }
//            productInfo.setProductStock(result);
//            productInfoRepository.save(productInfo);
//
//            productInfoList.add(productInfo);
//        }
//        return productInfoList;
//    }
//}
