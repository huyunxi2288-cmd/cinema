package com.cinema.dao;

import com.cinema.dto.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaHallDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 分页查询影厅列表
     */
    public List<CinemaHall> getCinemaHalls(int offset, int pageSize) {

        String sql = "SELECT * FROM 影厅表 " +
                "ORDER BY 影厅编号 " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{offset, pageSize},
                (rs, rowNum) ->
                        new CinemaHall(
                                rs.getString("影厅编号"),
                                rs.getString("影厅名称"),
                                rs.getInt("座位数"),
                                rs.getString("屏幕类型")
                        )
        );
    }

    /**
     * 根据影厅编号查询
     */
    public CinemaHall getCinemaHallById(String cinemaHallId) {

        String sql = "SELECT * FROM 影厅表 WHERE 影厅编号 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{cinemaHallId},
                (rs, rowNum) ->
                        new CinemaHall(
                                rs.getString("影厅编号"),
                                rs.getString("影厅名称"),
                                rs.getInt("座位数"),
                                rs.getString("屏幕类型")
                        )
        );
    }

    /**
     * 添加影厅
     */
    public void addCinemaHall(String cinemaHallId,
                              String cinemaHallName,
                              int seatCount,
                              String screenType) {

        String sql = "INSERT INTO 影厅表 " +
                "(影厅编号, 影厅名称, 座位数, 屏幕类型) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                cinemaHallId,
                cinemaHallName,
                seatCount,
                screenType
        );
    }

    /**
     * 更新影厅信息
     */
    public void updateCinemaHall(String cinemaHallId,
                                 String cinemaHallName,
                                 int seatCount,
                                 String screenType) {

        String sql = "UPDATE 影厅表 " +
                "SET 影厅名称 = ?, 座位数 = ?, 屏幕类型 = ? " +
                "WHERE 影厅编号 = ?";

        jdbcTemplate.update(
                sql,
                cinemaHallName,
                seatCount,
                screenType,
                cinemaHallId
        );
    }

    /**
     * 删除影厅
     */
    public void deleteCinemaHall(String cinemaHallId) {

        String sql = "DELETE FROM 影厅表 WHERE 影厅编号 = ?";

        jdbcTemplate.update(sql, cinemaHallId);
    }
}
