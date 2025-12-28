package com.cinema.controller;

import com.cinema.dto.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // 获取电影列表
    @GetMapping("/list")
    public List<Movie> getMovies(@RequestParam int pageNum, @RequestParam int pageSize) {
        return movieService.getMovies(pageNum, pageSize);
    }

    // 获取单个电影信息
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }

    // 添加电影
    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return "Movie added successfully";
    }

    // 更新电影
    @PutMapping("/update/{movieId}")
    public String updateMovie(@PathVariable String movieId, @RequestBody Movie movie) {
        movieService.updateMovie(movieId, movie);
        return "Movie updated successfully";
    }

    // 删除电影
    @DeleteMapping("/delete/{movieId}")
    public String deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);
        return "Movie deleted successfully";
    }
}
