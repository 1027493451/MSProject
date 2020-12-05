package com.imooc2.order.service;

import com.imooc2.order.dto.OrderDTO;

/**
 * @Author snail
 * @Description:
 * @create 2020-03-27 15:41
 * @Version 1.0
 **/
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);


    /**
     * 完成订单（只能卖家）
     *
     * @param orderId
     * @return OrderDTO
     */
    OrderDTO finish(String orderId);
}
