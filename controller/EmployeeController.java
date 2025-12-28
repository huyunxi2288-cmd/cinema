package com.cinema.controller;

import com.cinema.dto.Employee;
import com.cinema.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        employeeService.register(employee);
        return "注册成功";
    }


    // 登录接口
    @PostMapping("/login")
    public String login(@RequestParam String phone, @RequestParam String password) {
        try {
            Employee employee = employeeService.login(phone, password);

            if (employee != null) {
                // 判断是否为管理员
                if (employeeService.isAdmin(employee)) {
                    return "管理员登录成功";
                } else {
                    return "普通员工登录成功";
                }
            } else {
                return "登录失败，用户名或密码错误";
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();  // 返回管理员必须设置密码的错误信息
        }
    }
}
