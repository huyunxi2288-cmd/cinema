package com.cinema.controller;

import com.cinema.dto.Ticket;
import com.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // 获取某场次的所有票务信息
    @GetMapping("/list")
    public List<Ticket> getTicketsBySession(@RequestParam String sessionId) {
        return ticketService.getTicketsBySession(sessionId);
    }

    // 创建票务信息
    @PostMapping("/add")
    public String addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return "Ticket created successfully";
    }
}
