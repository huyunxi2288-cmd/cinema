package com.cinema.service;

import com.cinema.dao.CinemaSessionDao;
import com.cinema.dto.CinemaSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaSessionService {

    @Autowired
    private CinemaSessionDao cinemaSessionDao;

    // 获取所有场次信息
    public List<CinemaSession> getCinemaSessions(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return cinemaSessionDao.getCinemaSessions(offset, pageSize);
    }

    // 获取单个场次信息
    public CinemaSession getCinemaSessionById(String sessionId) {
        return cinemaSessionDao.getCinemaSessionById(sessionId);
    }

    // 添加场次信息
    public void addCinemaSession(String sessionId, String movieId, String cinemaHallId, String showTime, double price) {
        cinemaSessionDao.addCinemaSession(sessionId, movieId, cinemaHallId, showTime, price);
    }

    // 更新场次信息
    public void updateCinemaSession(String sessionId, String movieId, String cinemaHallId, String showTime, double price) {
        cinemaSessionDao.updateCinemaSession(sessionId, movieId, cinemaHallId, showTime, price);
    }

    // 删除场次信息
    public void deleteCinemaSession(String sessionId) {
        cinemaSessionDao.deleteCinemaSession(sessionId);
    }
}

