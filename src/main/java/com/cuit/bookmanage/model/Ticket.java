package com.cuit.bookmanage.model;

import java.util.Date;

public class Ticket {
    private Long id;

    private Long userId;

    private String ticket;

    private Date expiredAt;

    public Ticket(Long id, Long userId, String ticket, Date expiredAt) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.expiredAt = expiredAt;
    }

    public Ticket() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }
}