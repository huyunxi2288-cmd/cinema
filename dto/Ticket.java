package com.cinema.dto;

public class Ticket {
    private String ticketId;        // 票务编号
    private String sessionId;       // 场次编号
    private String seatNumber;      // 座位号
    private double price;           // 票价
    private String status;          // 票务状态（已售、未售）
    private String saleTime;        // 售票时间

    // Constructor
    public Ticket(String ticketId, String sessionId, String seatNumber, double price, String status, String saleTime) {
        this.ticketId = ticketId;
        this.sessionId = sessionId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
        this.saleTime = saleTime;
    }

    // Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }
}
