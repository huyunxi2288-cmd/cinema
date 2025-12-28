package com.cinema.dto;

public class CinemaHall {
    private String cinemaHallId;    // 影厅编号
    private String cinemaHallName;  // 影厅名称
    private int seatCount;          // 座位数
    private String screenType;      // 屏幕类型

    // Constructor
    public CinemaHall(String cinemaHallId, String cinemaHallName, int seatCount, String screenType) {
        this.cinemaHallId = cinemaHallId;
        this.cinemaHallName = cinemaHallName;
        this.seatCount = seatCount;
        this.screenType = screenType;
    }

    // Getters and Setters
    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(String cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaHallName() {
        return cinemaHallName;
    }

    public void setCinemaHallName(String cinemaHallName) {
        this.cinemaHallName = cinemaHallName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
}
