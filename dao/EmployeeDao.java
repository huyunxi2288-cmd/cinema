package com.cinema.dao;

import com.cinema.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据手机号和密码查询员工信息
     */
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO dbo.员工表 " +
                "(员工编号, 姓名, 职位, 联系电话, 密码) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                employee.getEmployeeId(),
                employee.getName(),
                employee.getPosition(),
                employee.getPhone(),
                employee.getPassword());
    }

    public Employee getEmployeeByPhoneAndPassword(String phone, String password) {

        String sql = "SELECT * FROM dbo.员工表 WHERE 联系电话 = ? AND 密码 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{phone, password},
                (rs, rowNum) ->
                        new Employee(
                                rs.getString("员工编号"),
                                rs.getString("姓名"),
                                rs.getString("职位"),
                                rs.getString("联系电话"),
                                rs.getString("密码")
                        )
        );
    }
}
