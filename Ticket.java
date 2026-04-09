package com.metroApp.metroTicket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    private String id;

    private String source;
    private String destination;

    private double price;

    private LocalDateTime createdTime;
    private LocalDateTime expiryTime;

    private boolean entryUsed;
    private boolean exitUsed;

    // Default Constructor
    public Ticket() {
    }

    // Parameterized Constructor
    public Ticket(String id, String source, String destination, double price,
                  LocalDateTime createdTime, LocalDateTime expiryTime,
                  boolean entryUsed, boolean exitUsed) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.createdTime = createdTime;
        this.expiryTime = expiryTime;
        this.entryUsed = entryUsed;
        this.exitUsed = exitUsed;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public boolean isEntryUsed() {
        return entryUsed;
    }

    public void setEntryUsed(boolean entryUsed) {
        this.entryUsed = entryUsed;
    }

    public boolean isExitUsed() {
        return exitUsed;
    }

    public void setExitUsed(boolean exitUsed) {
        this.exitUsed = exitUsed;
    }
}
