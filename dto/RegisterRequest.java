package com.cinema.dto;

public class RegisterRequest {
    private String nick;
    private String phone;
    private String password;

    // 构造函数、Getter和Setter（类似LoginRequest）
    public RegisterRequest() {}

    public RegisterRequest(String nick, String phone, String password) {
        this.nick = nick;
        this.phone = phone;
        this.password = password;
    }

    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}