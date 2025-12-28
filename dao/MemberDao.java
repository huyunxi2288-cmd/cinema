package com.cinema.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加公共的getter方法（方案2的核心）
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * 会员注册 - 调用存储过程
     */
    public Map<String, Object> registerMember(String nick, String phone, String pwd) {
        Map<String, Object> result = new HashMap<>();

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            CallableStatement cs = conn.prepareCall("{call usp_会员注册处理(?, ?, ?, ?, ?)}");
            cs.setString(1, nick);
            cs.setString(2, phone);
            cs.setString(3, pwd);
            cs.registerOutParameter(4, Types.VARCHAR); // 观众编号输出
            cs.registerOutParameter(5, Types.VARCHAR); // 注册结果输出

            cs.execute();

            String audienceId = cs.getString(4);
            String registerResult = cs.getString(5);

            result.put("success", registerResult.startsWith("成功"));
            result.put("message", registerResult);
            result.put("audienceId", audienceId);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "系统错误: " + e.getMessage());
        }

        return result;
    }

    /**
     * 会员登录
     */
    public Map<String, Object> loginMember(String phone, String password) {
        Map<String, Object> result = new HashMap<>();

        try {
            // ⚠️ 把 密码 → pwd
            String sql = "SELECT 观众编号, 昵称 FROM 观众表 WHERE 电话 = ? AND pwd = ?";
            Map<String, Object> member = jdbcTemplate.queryForMap(sql, phone, password);

            result.put("success", true);
            result.put("message", "登录成功");
            result.put("data", member);

        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "手机号或密码错误");
        }

        return result;
    }


    /**
     * 检查手机号是否已注册
     */
    public boolean isPhoneRegistered(String phone) {
        try {
            String sql = "SELECT COUNT(*) FROM 观众表 WHERE 电话 = ?";
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class, phone);
            return count != null && count > 0;
        } catch (Exception e) {
            return false;
        }
    }
}