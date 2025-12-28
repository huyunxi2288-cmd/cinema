package com.cinema.dto;

public class Payment {
    private String paymentId;        // 支付编号
    private String orderId;          // 订单编号
    private double paymentAmount;    // 支付金额
    private String paymentMethod;    // 支付方式
    private String paymentTime;      // 支付时间
    private String paymentStatus;    // 支付状态

    // Constructor
    public Payment(String paymentId, String orderId, double paymentAmount, String paymentMethod,
                   String paymentTime, String paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
