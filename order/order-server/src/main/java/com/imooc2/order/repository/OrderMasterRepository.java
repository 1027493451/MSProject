package com.imooc2.order.repository;

import com.imooc2.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: snail
 * @create: 11:50 2020/3/27
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
