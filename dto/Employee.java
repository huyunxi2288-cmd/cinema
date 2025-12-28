package com.cinema.dto;

public class Employee {
    private String employeeId;   // 员工编号
    private String name;         // 姓名
    private String position;     // 职位（普通员工、管理员）
    private String phone;        // 联系电话
    private String password;     // 密码

    // Constructor
    public Employee(String employeeId, String name, String position, String phone, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.password = password;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
