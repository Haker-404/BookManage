package com.cuit.bookmanage.model;

import java.util.Date;

public class Ticket {
    private Integer id;

    private Integer userId;

    private String ticket;

    private Date expiredAt;

    public Ticket(Integer id, Integer userId, String ticket, Date expiredAt) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.expiredAt = expiredAt;
    }

    public Ticket() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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