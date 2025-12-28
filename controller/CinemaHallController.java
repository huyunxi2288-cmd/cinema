package com.cinema.controller;

import com.cinema.dto.CinemaHall;
import com.cinema.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaHall")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    // 获取影厅列表
    @GetMapping("/list")
    public List<CinemaHall> getCinemaHalls(@RequestParam int pageNum, @RequestParam int pageSize) {
        return cinemaHallService.getCinemaHalls(pageNum, pageSize);
    }

    // 获取单个影厅信息
    @GetMapping("/{cinemaHallId}")
    public CinemaHall getCinemaHall(@PathVariable String cinemaHallId) {
        return cinemaHallService.getCinemaHallById(cinemaHallId);
    }

    // 添加影厅信息
    @PostMapping("/add")
    public String addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        cinemaHallService.addCinemaHall(cinemaHall.getCinemaHallId(), cinemaHall.getCinemaHallName(),
                cinemaHall.getSeatCount(), cinemaHall.getScreenType());
        return "Cinema Hall added successfully";
    }

    // 更新影厅信息
    @PutMapping("/update/{cinemaHallId}")
    public String updateCinemaHall(@PathVariable String cinemaHallId, @RequestBody CinemaHall cinemaHall) {
        cinemaHallService.updateCinemaHall(cinemaHallId, cinemaHall.getCinemaHallName(),
                cinemaHall.getSeatCount(), cinemaHall.getScreenType());
        return "Cinema Hall updated successfully";
    }

    // 删除影厅信息
    @DeleteMapping("/delete/{cinemaHallId}")
    public String deleteCinemaHall(@PathVariable String cinemaHallId) {
        cinemaHallService.deleteCinemaHall(cinemaHallId);
        return "Cinema Hall deleted successfully";
    }
}
