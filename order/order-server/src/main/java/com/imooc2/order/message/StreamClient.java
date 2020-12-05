package com.imooc2.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author snail
 * @Description:
 * @create: 2020-04-02 17:05
 * @Param $
 * @return $
 * @Version 1.0
 **/
public interface StreamClient {

//    String INPUT="myMessage";
//
//    String OUTPUT="myMessage";

    String INPUT = "input";
    String OUTPUT = "output";

    String INPUT2 = "input2";
    String OUTPUT2 = "output2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();

}
