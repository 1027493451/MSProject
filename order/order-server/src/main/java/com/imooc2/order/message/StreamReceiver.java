package com.imooc2.order.message;

import com.imooc2.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author snail
 * @Description: 接收端
 * @create: 2020-04-02 17:09
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message){
//        log.info("StreamReceiver:{}",message);
//    }

    /**
     * @param
     * @description: 接收OrderDTO对象消息
     * @author: snail
     * @create: 16:30 2020/4/9
     * @Version: 1.0
     * @return: void
     **/
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message) {
        log.info("StreamReceiver:{}", message);
        return "received";
    }

    @StreamListener(StreamClient.INPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2:{}", message);
    }
}
