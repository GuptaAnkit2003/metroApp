package com.metroApp.metroTicket.controller;

import com.metroApp.metroTicket.model.Ticket;
import com.metroApp.metroTicket.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // 🎯 1. Book Ticket
    @PostMapping("/book")
    public Ticket bookTicket(@RequestParam String source,
                             @RequestParam String destination) {
        return ticketService.bookTicket(source, destination);
    }

    // 🎯 2. Get Ticket by ID
    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable String id) {
        return ticketService.getTicket(id);
    }
    // 🎯 ENTRY API
    @PostMapping("/entry/{id}")
    public String entry(@PathVariable String id) {
        return ticketService.markEntry(id);
    }


    // 🎯 EXIT API
    @PostMapping("/exit/{id}")
    public String exit(@PathVariable String id) {
        return ticketService.markExit(id);
    }
}
