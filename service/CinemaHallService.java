package com.cinema.service;

import com.cinema.dao.CinemaHallDao;
import com.cinema.dto.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {

    @Autowired
    private CinemaHallDao cinemaHallDao;

    // 获取影厅列表
    public List<CinemaHall> getCinemaHalls(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return cinemaHallDao.getCinemaHalls(offset, pageSize);
    }

    // 获取单个影厅信息
    public CinemaHall getCinemaHallById(String cinemaHallId) {
        return cinemaHallDao.getCinemaHallById(cinemaHallId);
    }

    // 添加影厅信息
    public void addCinemaHall(String cinemaHallId, String cinemaHallName, int seatCount, String screenType) {
        cinemaHallDao.addCinemaHall(cinemaHallId, cinemaHallName, seatCount, screenType);
    }

    // 更新影厅信息
    public void updateCinemaHall(String cinemaHallId, String cinemaHallName, int seatCount, String screenType) {
        cinemaHallDao.updateCinemaHall(cinemaHallId, cinemaHallName, seatCount, screenType);
    }

    // 删除影厅信息
    public void deleteCinemaHall(String cinemaHallId) {
        cinemaHallDao.deleteCinemaHall(cinemaHallId);
    }
}

