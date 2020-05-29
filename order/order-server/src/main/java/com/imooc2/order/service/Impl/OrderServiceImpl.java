package com.imooc2.order.service.Impl;

import com.imooc2.order.dataobject.OrderDetail;
import com.imooc2.order.dataobject.OrderMaster;
import com.imooc2.order.dto.OrderDTO;
import com.imooc2.order.enums.OrderStatusEnum;
import com.imooc2.order.enums.ResultEnum;
import com.imooc2.order.exception.OrderException;
import com.imooc2.order.repository.OrderDetailRepository;
import com.imooc2.order.repository.OrderMasterRepository;
import com.imooc2.order.service.OrderService;
import com.imooc2.order.utils.KeyUtil;
import com.imooc2.product.client.ProductClient;
import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author snail
 * @Description:
 * @create: 2020-03-27 15:42
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        //查询商品信息（调用商品服务）
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList()));
        if (productInfoList == null) {
            throw new RuntimeException("服务超时，请重试");
        }

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ONE);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()
        ) {
            for (ProductInfoOutput productInfo : productInfoList
            ) {
                orderAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
                BeanUtils.copyProperties(productInfo, orderDetail);
                orderDetail.setOrderId(orderId);
                orderDetail.setDetailId(KeyUtil.genUniqueKey());
                //订单详情入库
                orderDetailRepository.save(orderDetail);
            }
        }
        //扣库存
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        //1.查询订单
        Optional<OrderMaster> optionalOrderMaster = orderMasterRepository.findById(orderId);
        if (!optionalOrderMaster.isPresent()) {
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.判断订单状态
        OrderMaster orderMaster = optionalOrderMaster.get();
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //3.修改订单状态为完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);
        //4.查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
