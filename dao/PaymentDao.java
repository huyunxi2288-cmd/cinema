package com.cinema.dao;

import com.cinema.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 分页查询支付记录（SQL Server 2019）
     */
    public List<Payment> getPayments(int offset, int pageSize) {
        String sql = "SELECT * FROM 支付记录表 " +
                "ORDER BY 支付时间 " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{offset, pageSize},
                (rs, rowNum) ->
                        new Payment(
                                rs.getString("支付编号"),
                                rs.getString("订单编号"),
                                rs.getDouble("支付金额"),
                                rs.getString("支付方式"),
                                rs.getString("支付时间"),
                                rs.getString("支付状态")
                        )
        );
    }

    /**
     * 根据支付编号查询支付记录
     */
    public Payment getPaymentById(String paymentId) {
        String sql = "SELECT * FROM 支付记录表 WHERE 支付编号 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{paymentId},
                (rs, rowNum) ->
                        new Payment(
                                rs.getString("支付编号"),
                                rs.getString("订单编号"),
                                rs.getDouble("支付金额"),
                                rs.getString("支付方式"),
                                rs.getString("支付时间"),
                                rs.getString("支付状态")
                        )
        );
    }

    /**
     * 新增支付记录
     * ⚠️ 支付状态一般初始为：未支付 / 已支付（由业务决定）
     */
    public void addPayment(String paymentId,
                           String orderId,
                           double paymentAmount,
                           String paymentMethod,
                           String paymentTime) {

        String sql = "INSERT INTO 支付记录表 " +
                "(支付编号, 订单编号, 支付金额, 支付方式, 支付时间, 支付状态) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                paymentId,
                orderId,
                paymentAmount,
                paymentMethod,
                paymentTime,
                "未支付"   // 初始状态（与你后面的 update 对应）
        );
    }

    /**
     * 更新支付状态
     */
    public void updatePaymentStatus(String paymentId, String paymentStatus) {
        String sql = "UPDATE 支付记录表 SET 支付状态 = ? WHERE 支付编号 = ?";
        jdbcTemplate.update(sql, paymentStatus, paymentId);
    }
}

