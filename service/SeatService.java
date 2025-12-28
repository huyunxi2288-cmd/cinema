package com.cinema.service;

import com.cinema.dao.SeatDao;
import com.cinema.dto.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatDao seatDao;

    // 获取场次所有座位信息
    public List<Seat> getSeatsBySession(String sessionId) {
        return seatDao.getSeatsBySession(sessionId);
    }

    // 更新座位状态
    public void updateSeatStatus(String sessionId, String seatNumber, String seatStatus) {
        seatDao.updateSeatStatus(sessionId, seatNumber, seatStatus);
    }
}
