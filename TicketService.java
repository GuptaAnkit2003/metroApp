package com.metroApp.metroTicket.service;

import com.metroApp.metroTicket.model.Ticket;
import com.metroApp.metroTicket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // 🎯 Book Ticket
    public Ticket bookTicket(String source, String destination) {

        Ticket ticket = new Ticket();

        ticket.setId(UUID.randomUUID().toString());
        ticket.setSource(source);
        ticket.setDestination(destination);

        // Simple price logic (you can improve later)
        ticket.setPrice(50.0);

        ticket.setCreatedTime(LocalDateTime.now());
        ticket.setExpiryTime(LocalDateTime.now().plusHours(18));

        ticket.setEntryUsed(false);
        ticket.setExitUsed(false);

        return ticketRepository.save(ticket);
    }

    // 🎯 Get Ticket
    public Ticket getTicket(String id) {
        return ticketRepository.findById(id).orElse(null);
    }
    // 🎯 ENTRY VALIDATION
    public String markEntry(String id) {

        System.out.println("Incoming ID: " + id);
        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if (ticket == null) {
            return "Ticket not found!";
        }

        if (ticket.isEntryUsed()) {
            return "Entry already used!";
        }

        if (ticket.getExpiryTime().isBefore(LocalDateTime.now())) {
            return "Ticket expired!";
        }

        ticket.setEntryUsed(true);
        ticketRepository.save(ticket);

        return "Entry successful!";
    }


    // 🎯 EXIT VALIDATION
    public String markExit(String id) {

        Ticket ticket = ticketRepository.findById(id).orElse(null);

        if (ticket == null) {
            return "Ticket not found!";
        }

        if (!ticket.isEntryUsed()) {
            return "Entry not done yet!";
        }

        if (ticket.isExitUsed()) {
            return "Exit already done!";
        }

        if (ticket.getExpiryTime().isBefore(LocalDateTime.now())) {
            return "Ticket expired!";
        }

        ticket.setExitUsed(true);
        ticketRepository.save(ticket);

        return "Exit successful!";
    }
}
