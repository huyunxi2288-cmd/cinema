package com.cinema.dto;

public class Seat {
    private String sessionId;       // 场次编号
    private String seatNumber;      // 座位号
    private String seatStatus;      // 座位状态（空、占）

    // Constructor
    public Seat(String sessionId, String seatNumber, String seatStatus) {
        this.sessionId = sessionId;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    // Getters and Setters
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

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
