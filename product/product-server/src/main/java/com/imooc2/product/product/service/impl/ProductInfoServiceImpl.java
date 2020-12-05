package com.imooc2.product.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.common.ProductInfoOutput;
import com.imooc2.product.enums.ProductStatusEnum;
import com.imooc2.product.enums.ResultEnum;
import com.imooc2.product.exception.ProductException;
import com.imooc2.product.product.dao.ProductInfoMapper;
import com.imooc2.product.product.entity.ProductInfo;
import com.imooc2.product.product.service.IProductInfoService;
import com.imooc2.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        QueryWrapper<ProductInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().ge(ProductInfo::getProductStatus,ProductStatusEnum.UP.getCode());
        return productInfoMapper.selectList(queryWrapper);
       // return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        //线程睡眠两秒后在运行，用于测试服务降价和超时设置
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<ProductInfo> list=productInfoMapper.findList(productIdList);
        return productInfoMapper.selectBatchIds(productIdList);
        //return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e, output);
            return output;
        }).collect(Collectors.toList());

        //发送MQ消息
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {

        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList
        ) {
            ProductInfo productInfo  = productInfoMapper.selectById(decreaseStockInput.getProductId());
            //Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
//            if (!productInfoOptional.isPresent()) {
//                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
//            }
//            ProductInfo productInfo = productInfoOptional.get();
            if(productInfo==null){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoMapper.updateById(productInfo);
            //productInfoRepository.save(productInfo);

            productInfoList.add(productInfo);
        }
        return productInfoList;
    }

}
