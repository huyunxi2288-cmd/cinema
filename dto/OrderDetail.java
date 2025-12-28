package com.cinema.dto;

public class OrderDetail {
    private String detailId;        // 明细编号
    private String orderId;         // 订单编号
    private String productType;     // 商品类型（票务/食品）
    private String productId;       // 商品编号
    private int quantity;           // 购买数量
    private double unitPrice;       // 单价
    private double subtotal;        // 小计金额

    // Constructor
    public OrderDetail(String detailId, String orderId, String productType, String productId,
                       int quantity, double unitPrice, double subtotal) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productType = productType;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
