package com.cinema.controller;

import com.cinema.dto.Seat;
import com.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // 获取某场次的所有座位
    @GetMapping("/list")
    public List<Seat> getSeatsBySession(@RequestParam String sessionId) {
        return seatService.getSeatsBySession(sessionId);
    }

    // 更新座位状态
    @PutMapping("/update")
    public String updateSeatStatus(@RequestParam String sessionId, @RequestParam String seatNumber, @RequestParam String seatStatus) {
        seatService.updateSeatStatus(sessionId, seatNumber, seatStatus);
        return "Seat status updated successfully";
    }
}
