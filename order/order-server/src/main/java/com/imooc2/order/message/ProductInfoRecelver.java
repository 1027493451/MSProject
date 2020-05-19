package com.imooc2.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.imooc2.order.utils.JsonUtil;
import com.imooc2.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-10 10:13
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Component
@Slf4j
public class ProductInfoRecelver {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";

    /**
    * @description: 接收队列为productInfo 的MQ消息
    * @author: snail
    * @create: 10:28 2020/4/10
    * @Version: 1.0
    * @param message
    * @return: void
    **/
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        //message => ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(message, new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列[{}]接受消息：{}","productInfo",productInfoOutputList);

        productInfoOutputList.forEach(e->{
            //存储到redis
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,e.getProductId()),
                    String.valueOf(e.getProductStock()));
        });
    }
}
