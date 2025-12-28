package com.cinema.dao;

import com.cinema.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 分页查询电影
     */
    public List<Movie> getMovies(int offset, int limit) {

        String sql = "SELECT * FROM dbo.电影表 " +
                "ORDER BY 电影编号 " +
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        return jdbcTemplate.query(
                sql,
                new Object[]{offset, limit},
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("电影编号"),
                                rs.getString("电影名称"),
                                rs.getInt("时长"),
                                rs.getString("类型"),
                                rs.getString("上映日期"),
                                rs.getString("导演"),
                                rs.getString("简介")
                        )
        );
    }

    /**
     * 根据电影编号查询
     */
    public Movie getMovieById(String movieId) {

        String sql = "SELECT * FROM dbo.电影表 WHERE 电影编号 = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{movieId},
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("电影编号"),
                                rs.getString("电影名称"),
                                rs.getInt("时长"),
                                rs.getString("类型"),
                                rs.getString("上映日期"),
                                rs.getString("导演"),
                                rs.getString("简介")
                        )
        );
    }

    /**
     * 添加电影
     */
    public void addMovie(Movie movie) {

        String sql = "INSERT INTO dbo.电影表 " +
                "(电影编号, 电影名称, 时长, 类型, 上映日期, 导演, 简介) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                movie.getMovieId(),
                movie.getMovieName(),
                movie.getDuration(),
                movie.getType(),
                movie.getReleaseDate(),
                movie.getDirector(),
                movie.getDescription()
        );
    }

    /**
     * 更新电影
     */
    public void updateMovie(String movieId, Movie movie) {

        String sql = "UPDATE dbo.电影表 SET " +
                "电影名称 = ?, 时长 = ?, 类型 = ?, 上映日期 = ?, 导演 = ?, 简介 = ? " +
                "WHERE 电影编号 = ?";

        jdbcTemplate.update(
                sql,
                movie.getMovieName(),
                movie.getDuration(),
                movie.getType(),
                movie.getReleaseDate(),
                movie.getDirector(),
                movie.getDescription(),
                movieId
        );
    }

    /**
     * 删除电影
     */
    public void deleteMovie(String movieId) {

        String sql = "DELETE FROM dbo.电影表 WHERE 电影编号 = ?";

        jdbcTemplate.update(sql, movieId);
    }
}
