package com.cinema.service;

import com.cinema.dao.OrderDao;
import com.cinema.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    // 获取指定会员的所有订单（分页）
    public List<Order> getOrdersByMemberId(String audienceId, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;  // 计算偏移量
        return orderDao.getOrdersByMemberId(audienceId, offset, pageSize);  // 调用 DAO 层方法
    }

    // 获取所有订单（分页）
    public List<Order> getOrders(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return orderDao.getOrders(offset, pageSize);
    }

    // 获取单个订单
    public Order getOrderById(String orderId) {
        return orderDao.getOrderById(orderId);
    }

    // 创建订单
    public void addOrder(String orderId, String orderTime, double totalAmount, String orderStatus) {
        orderDao.addOrder(orderId, orderTime, totalAmount, orderStatus);
    }

    // 更新订单状态
    public void updateOrderStatus(String orderId, String orderStatus) {
        orderDao.updateOrderStatus(orderId, orderStatus);
    }

    // 删除订单
    public void deleteOrder(String orderId) {
        orderDao.deleteOrder(orderId);
    }
}
