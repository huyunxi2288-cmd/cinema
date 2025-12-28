package com.cinema.dto;

public class CinemaSession {
    private String sessionId;       // 场次编号
    private String movieId;         // 电影编号
    private String cinemaHallId;    // 影厅编号
    private String showTime;        // 放映时间
    private double price;           // 票价

    // Constructor
    public CinemaSession(String sessionId, String movieId, String cinemaHallId, String showTime, double price) {
        this.sessionId = sessionId;
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
        this.price = price;
    }

    // Getters and Setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(String cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
