package com.cinema.dto;

public class Order {
    private String orderId;          // 订单编号
    private String orderTime;        // 订单时间
    private double totalAmount;      // 总金额
    private String orderStatus;      // 订单状态

    // Constructor
    public Order(String orderId, String orderTime, double totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
