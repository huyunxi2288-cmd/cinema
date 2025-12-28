package com.cinema.service;

import com.cinema.dao.TicketDao;
import com.cinema.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    // 获取某场次的所有票务信息
    public List<Ticket> getTicketsBySession(String sessionId) {
        return ticketDao.getTicketsBySession(sessionId);
    }

    // 创建票务信息
    public void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket.getTicketId(), ticket.getSessionId(),
                ticket.getSeatNumber(), ticket.getPrice(),
                ticket.getStatus(), ticket.getSaleTime());
    }
}
