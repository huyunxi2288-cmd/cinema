package com.cinema.controller;

import com.cinema.dto.Order;
import com.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 获取指定会员的所有订单（分页）
    @GetMapping("/member/{audienceId}")
    public List<Order> getOrdersByMemberId(@PathVariable String audienceId,
                                           @RequestParam int pageNum,
                                           @RequestParam int pageSize) {
        // 使用传递的 audienceId 查询该会员的订单
        return orderService.getOrdersByMemberId(audienceId, pageNum, pageSize);
    }

    // 获取所有订单（分页）
    @GetMapping("/list")
    public List<Order> getOrders(@RequestParam int pageNum, @RequestParam int pageSize) {
        return orderService.getOrders(pageNum, pageSize);
    }

    // 获取单个订单
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    // 创建订单
    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order.getOrderId(), order.getOrderTime(),
                order.getTotalAmount(), order.getOrderStatus());
        return "Order created successfully";
    }

    // 更新订单状态
    @PutMapping("/update/{orderId}")
    public String updateOrderStatus(@PathVariable String orderId, @RequestBody Order order) {
        orderService.updateOrderStatus(orderId, order.getOrderStatus());
        return "Order status updated successfully";
    }

    // 删除订单
    @DeleteMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return "Order deleted successfully";
    }
}

