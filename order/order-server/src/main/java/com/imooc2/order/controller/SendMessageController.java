package com.imooc2.order.controller;

import com.imooc2.order.dto.OrderDTO;
import com.imooc2.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author snail
 * @Description: Stream发送端
 * @create: 2020-04-02 17:12
 * @Param $
 * @return $
 * @Version 1.0
 **/
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        String message="now"+new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }


    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
