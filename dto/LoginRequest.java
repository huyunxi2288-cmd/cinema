package com.cinema.dto;

public class LoginRequest {
    private String phone;
    private String password;

    // 构造函数
    public LoginRequest() {}

    public LoginRequest(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    // Getter和Setter
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}