package com.cinema.dao;

import com.cinema.dto.CinemaSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaSessionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 分页查询场次信息
     */
    public List<CinemaSession> getCinemaSessions(int offset, int pageSize) {
        String sql = "SELECT * FROM 放映场次表 " +
                "ORDER BY 放映时间 " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{offset, pageSize},
                (rs, rowNum) ->
                        new CinemaSession(
                                rs.getString("场次编号"),
                                rs.getString("电影编号"),
                                rs.getString("影厅编号"),
                                rs.getString("放映时间"),
                                rs.getDouble("票价")
                        )
        );
    }

    /**
     * 根据场次编号查询
     */
    public CinemaSession getCinemaSessionById(String sessionId) {
        String sql = "SELECT * FROM 放映场次表 WHERE 场次编号 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{sessionId},
                (rs, rowNum) ->
                        new CinemaSession(
                                rs.getString("场次编号"),
                                rs.getString("电影编号"),
                                rs.getString("影厅编号"),
                                rs.getString("放映时间"),
                                rs.getDouble("票价")
                        )
        );
    }

    /**
     * 添加场次
     */
    public void addCinemaSession(String sessionId,
                                 String movieId,
                                 String cinemaHallId,
                                 String showTime,
                                 double price) {

        String sql = "INSERT INTO 放映场次表 " +
                "(场次编号, 电影编号, 影厅编号, 放映时间, 票价) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                sessionId,
                movieId,
                cinemaHallId,
                showTime,
                price
        );
    }

    /**
     * 更新场次
     */
    public void updateCinemaSession(String sessionId,
                                    String movieId,
                                    String cinemaHallId,
                                    String showTime,
                                    double price) {

        String sql = "UPDATE 放映场次表 SET " +
                "电影编号 = ?, 影厅编号 = ?, 放映时间 = ?, 票价 = ? " +
                "WHERE 场次编号 = ?";

        jdbcTemplate.update(
                sql,
                movieId,
                cinemaHallId,
                showTime,
                price,
                sessionId
        );
    }

    /**
     * 删除场次
     */
    public void deleteCinemaSession(String sessionId) {
        String sql = "DELETE FROM 放映场次表 WHERE 场次编号 = ?";
        jdbcTemplate.update(sql, sessionId);
    }
}
