package com.cinema.dao;

import com.cinema.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * RowMapper 用于映射查询结果
     */
    private final RowMapper<Order> orderRowMapper = (rs, rowNum) -> new Order(
            rs.getString("订单编号"),
            rs.getString("订单时间"),
            rs.getDouble("总金额"),
            rs.getString("订单状态")
    );

    /**
     * 分页查询订单
     */
    public List<Order> getOrders(int offset, int pageSize) {

        String sql = "SELECT * FROM 订单表 " +
                "ORDER BY 订单时间 DESC " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{offset, pageSize},
                orderRowMapper
        );
    }

    /**
     * 根据会员ID分页查询订单
     */
    public List<Order> getOrdersByMemberId(String audienceId, int offset, int pageSize) {
        String sql = "SELECT * FROM 订单表 WHERE 观众编号 = ? " +
                "ORDER BY 订单时间 DESC " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{audienceId, offset, pageSize},
                (rs, rowNum) -> new Order(
                        rs.getString("订单编号"),
                        rs.getString("订单时间"),
                        rs.getDouble("总金额"),
                        rs.getString("订单状态")
                )
        );
    }


    /**
     * 根据会员ID和筛选条件查询订单
     */
    public List<Order> getFilteredOrders(String audienceId, String status, String startDate, String endDate, int offset, int pageSize) {
        String sql = "SELECT * FROM 订单表 WHERE 观众编号 = ? " +
                "AND 订单状态 = ? " +
                "AND 订单时间 BETWEEN ? AND ? " +
                "ORDER BY 订单时间 DESC " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return jdbcTemplate.query(
                sql,
                new Object[]{audienceId, status, startDate, endDate, offset, pageSize},
                orderRowMapper
        );
    }

    /**
     * 删除订单
     */
    public void deleteOrder(String orderId) {

        String sql = "DELETE FROM 订单表 WHERE 订单编号 = ?";

        jdbcTemplate.update(sql, orderId);
    }

    /**
     * 添加订单
     */
    public void addOrder(String orderId,
                         String orderTime,
                         double totalAmount,
                         String orderStatus) {

        String sql = "INSERT INTO 订单表 " +
                "(订单编号, 订单时间, 总金额, 订单状态) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                orderId,
                orderTime,
                totalAmount,
                orderStatus
        );
    }

    /**
     * 更新订单状态
     */
    public void updateOrderStatus(String orderId, String orderStatus) {

        String sql = "UPDATE 订单表 SET 订单状态 = ? WHERE 订单编号 = ?";

        jdbcTemplate.update(
                sql,
                orderStatus,
                orderId
        );
    }

    /**
     * 获取单个订单
     */
    public Order getOrderById(String orderId) {

        String sql = "SELECT * FROM 订单表 WHERE 订单编号 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{orderId},
                orderRowMapper
        );
    }
}
