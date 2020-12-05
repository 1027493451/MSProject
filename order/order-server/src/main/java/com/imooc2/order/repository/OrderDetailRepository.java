package com.imooc2.order.repository;

import com.imooc2.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: snail
 * @create: 11:50 2020/3/27
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
