package com.cinema.controller;

import com.cinema.dto.OrderDetail;
import com.cinema.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    // 获取指定订单的订单明细
    @GetMapping("/list")
    public List<OrderDetail> getOrderDetails(@RequestParam String orderId) {
        return orderDetailService.getOrderDetailsByOrderId(orderId);
    }

    // 创建订单明细
    @PostMapping("/add")
    public String addOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailService.addOrderDetail(orderDetail);
        return "Order detail added successfully";
    }

    // 删除订单明细
    @DeleteMapping("/delete/{detailId}")
    public String deleteOrderDetail(@PathVariable String detailId) {
        orderDetailService.deleteOrderDetail(detailId);
        return "Order detail deleted successfully";
    }
}
