package com.imooc2.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author snail
 * @Description: 接受MQ消息
 * @create: 2020-04-02 14:37
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Component
@Slf4j
public class MqReceiver {

    //1. @RabbitListener(queues = "myQueue")
    //2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建  Exchange和Queue 绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver:{}", message);
    }

    /**
     * @param message
     * @description: 用不同方法模拟不同服务调用消息队列，发送消息用测试类实现
     * kry是不同类型
     * @author: snail
     * @create: 15:16 2020/4/2
     * @Version: 1.0
     * @return: void
     **/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myQueue"),
            key = "computer"
    ))
    public void processComputer(String message) {
        log.info("computer MqReceiver:{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            exchange = @Exchange("myQueue"),
            key = "fruit"
    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver:{}", message);
    }
}
