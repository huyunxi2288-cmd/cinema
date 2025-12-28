package com.cinema.dao;

import com.cinema.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取某场次的所有票务信息
     */
    public List<Ticket> getTicketsBySession(String sessionId) {
        String sql = "SELECT * FROM dbo.票务信息表 WHERE 场次编号 = ?";

        return jdbcTemplate.query(sql, new Object[]{sessionId},
                (rs, rowNum) -> {
                    String ticketId = rs.getString("票务编号");
                    String sessionIdDb = rs.getString("场次编号");
                    String seatNumber = rs.getString("座位号");
                    double price = rs.getDouble("票价");
                    String status = rs.getString("状态");
                    String saleTime = rs.getString("售票时间");

                    return new Ticket(
                            ticketId,
                            sessionIdDb,
                            seatNumber,
                            price,
                            status,
                            saleTime
                    );
                }
        );
    }

    /**
     * 创建票务信息
     */
    public void addTicket(String ticketId,
                          String sessionId,
                          String seatNumber,
                          double price,
                          String status,
                          String saleTime) {

        String sql = "INSERT INTO dbo.票务信息表 " +
                "(票务编号, 场次编号, 座位号, 票价, 状态, 售票时间) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                ticketId,
                sessionId,
                seatNumber,
                price,
                status,
                saleTime
        );
    }
}
