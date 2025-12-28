package com.cinema.controller;

import com.cinema.dto.CinemaSession;
import com.cinema.service.CinemaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaSession")
public class CinemaSessionController {

    @Autowired
    private CinemaSessionService cinemaSessionService;

    // 获取场次列表
    @GetMapping("/list")
    public List<CinemaSession> getCinemaSessions(@RequestParam int pageNum, @RequestParam int pageSize) {
        return cinemaSessionService.getCinemaSessions(pageNum, pageSize);
    }

    // 获取单个场次信息
    @GetMapping("/{sessionId}")
    public CinemaSession getCinemaSession(@PathVariable String sessionId) {
        return cinemaSessionService.getCinemaSessionById(sessionId);
    }

    // 添加场次信息
    @PostMapping("/add")
    public String addCinemaSession(@RequestBody CinemaSession cinemaSession) {
        cinemaSessionService.addCinemaSession(cinemaSession.getSessionId(), cinemaSession.getMovieId(),
                cinemaSession.getCinemaHallId(), cinemaSession.getShowTime(), cinemaSession.getPrice());
        return "Cinema session added successfully";
    }

    // 更新场次信息
    @PutMapping("/update/{sessionId}")
    public String updateCinemaSession(@PathVariable String sessionId, @RequestBody CinemaSession cinemaSession) {
        cinemaSessionService.updateCinemaSession(sessionId, cinemaSession.getMovieId(),
                cinemaSession.getCinemaHallId(), cinemaSession.getShowTime(), cinemaSession.getPrice());
        return "Cinema session updated successfully";
    }

    // 删除场次信息
    @DeleteMapping("/delete/{sessionId}")
    public String deleteCinemaSession(@PathVariable String sessionId) {
        cinemaSessionService.deleteCinemaSession(sessionId);
        return "Cinema session deleted successfully";
    }
}

