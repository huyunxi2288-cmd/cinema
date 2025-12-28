package com.cinema.dao;

import com.cinema.dto.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询某场次的所有座位
     */
    public List<Seat> getSeatsBySession(String sessionId) {

        String sql = "SELECT * FROM 座位表 WHERE 场次编号 = ? ORDER BY 座位号";

        return jdbcTemplate.query(
                sql,
                new Object[]{sessionId},
                (rs, rowNum) ->
                        new Seat(
                                rs.getString("场次编号"),
                                rs.getString("座位号"),
                                rs.getString("座位状态")
                        )
        );
    }

    /**
     * 更新座位状态
     */
    public void updateSeatStatus(String sessionId, String seatNumber, String seatStatus) {

        String sql = "UPDATE 座位表 SET 座位状态 = ? WHERE 场次编号 = ? AND 座位号 = ?";

        jdbcTemplate.update(
                sql,
                seatStatus,
                sessionId,
                seatNumber
        );
    }
}
