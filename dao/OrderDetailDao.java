package com.cinema.dao;

import com.cinema.dto.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 根据订单编号查询明细
    public List<OrderDetail> findByOrderId(String orderId) {
        String sql = "SELECT * FROM 订单明细表 WHERE 订单编号 = ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{orderId},
                (rs, rowNum) ->
                        new OrderDetail(
                                rs.getString("明细编号"),
                                rs.getString("订单编号"),
                                rs.getString("商品类型"),
                                rs.getString("商品编号"),
                                rs.getInt("数量"),
                                rs.getDouble("单价"),
                                rs.getDouble("小计金额")
                        )
        );
    }

    // 添加订单明细
    public void addOrderDetail(OrderDetail detail) {
        String sql = "INSERT INTO 订单明细表 " +
                "(明细编号, 订单编号, 商品类型, 商品编号, 数量, 单价, 小计金额) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                detail.getDetailId(),
                detail.getOrderId(),
                detail.getProductType(),
                detail.getProductId(),
                detail.getQuantity(),
                detail.getUnitPrice(),
                detail.getSubtotal()
        );
    }

    // 根据明细编号删除
    public void deleteByDetailId(String detailId) {
        String sql = "DELETE FROM 订单明细表 WHERE 明细编号 = ?";
        jdbcTemplate.update(sql, detailId);
    }
}
