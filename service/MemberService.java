package com.cinema.service;

import com.cinema.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    /**
     * 处理会员注册
     */
    public Map<String, Object> register(String nick, String phone, String password) {
        Map<String, Object> result = new HashMap<>();

        // 1. 验证输入
        if (nick == null || nick.trim().isEmpty()) {
            result.put("success", false);
            result.put("message", "昵称不能为空");
            return result;
        }

        if (phone == null || phone.trim().isEmpty() || phone.length() != 11) {
            result.put("success", false);
            result.put("message", "请输入11位手机号");
            return result;
        }

        if (password == null || password.trim().isEmpty()) {
            result.put("success", false);
            result.put("message", "密码不能为空");
            return result;
        }

        // 2. 检查手机号是否已注册
        if (memberDao.isPhoneRegistered(phone)) {
            result.put("success", false);
            result.put("message", "该手机号已注册");
            return result;
        }

        // 3. 调用DAO层进行注册
        return memberDao.registerMember(nick, phone, password);
    }

    /**
     * 处理会员登录
     */
    public Map<String, Object> login(String phone, String password) {
        Map<String, Object> result = new HashMap<>();

        // 1. 验证输入
        if (phone == null || phone.trim().isEmpty()) {
            result.put("success", false);
            result.put("message", "手机号不能为空");
            return result;
        }

        if (password == null || password.trim().isEmpty()) {
            result.put("success", false);
            result.put("message", "密码不能为空");
            return result;
        }

        // 2. 调用DAO层进行登录
        return memberDao.loginMember(phone, password);
    }

    /**
     * 获取会员信息 - 修改后的版本（修复了SQL注入问题）
     * 对应您图片中的第82行错误
     */
    public Map<String, Object> getMemberInfo(String audienceId) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 修正SQL语句：
            // 1. 使用英文逗号替换中文逗号
            // 2. 使用参数化查询防止SQL注入
            // 3. 通过getter方法访问jdbcTemplate（方案2的核心）
            String sql = "SELECT 观众编号, 昵称, 电话, 注册时间 FROM 观众表 WHERE 观众编号 = ?";

            // 通过getter获取jdbcTemplate，然后进行查询
            Map<String, Object> member = memberDao.getJdbcTemplate()
                    .queryForMap(sql, audienceId);  // 这里audienceId是参数，不是拼接

            result.put("success", true);
            result.put("message", "获取成功");
            result.put("data", member);

        } catch (Exception e) {
            // 如果查询出错（比如没有找到会员）
            result.put("success", false);
            result.put("message", "会员不存在或查询失败");
        }

        return result;
    }
}