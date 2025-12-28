package com.cinema.service;

import com.cinema.dao.EmployeeDao;
import com.cinema.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    // 登录验证
    public Employee login(String phone, String password) {
        Employee employee = employeeDao.getEmployeeByPhoneAndPassword(phone, password);

        // 检查管理员是否有密码
        if (employee != null && "管理员".equals(employee.getPosition()) && (password == null || password.isEmpty())) {
            throw new IllegalArgumentException("管理员必须设置密码");
        }

        return employee;
    }
    public void register(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    // 判断是否是管理员
    public boolean isAdmin(Employee employee) {
        return "管理员".equals(employee.getPosition());
    }
}
