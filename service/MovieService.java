package com.cinema.service;

import com.cinema.dao.MovieDao;
import com.cinema.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    // 获取电影列表
    public List<Movie> getMovies(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return movieDao.getMovies(offset, pageSize);
    }

    // 获取单个电影信息
    public Movie getMovieById(String movieId) {
        return movieDao.getMovieById(movieId);
    }

    // 添加电影
    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    // 更新电影信息
    public void updateMovie(String movieId, Movie movie) {
        movieDao.updateMovie(movieId, movie);
    }

    // 删除电影
    public void deleteMovie(String movieId) {
        movieDao.deleteMovie(movieId);
    }
}
