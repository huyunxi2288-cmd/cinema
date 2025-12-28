package com.cinema.service;

import com.cinema.dao.OrderDetailDao;
import com.cinema.dto.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    // 根据订单编号获取所有明细
    public List<OrderDetail> getOrderDetailsByOrderId(String orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

    // 添加订单明细
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDao.addOrderDetail(orderDetail);
    }

    // 删除订单明细
    public void deleteOrderDetail(String detailId) {
        orderDetailDao.deleteByDetailId(detailId);
    }
}

