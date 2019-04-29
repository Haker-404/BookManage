package com.cuit.bookmanage.utils;

import com.cuit.bookmanage.model.Ticket;

import java.util.Date;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/28 19:00
 * @Version 1.0
 **/
public class TicketUtils {
    public static Ticket next(int uid){
        Ticket ticket = new Ticket();
        ticket.setTicket(UuidUtils.next());
        ticket.setUserId(uid);
        //设置t票过期时间
        Date expiredTime = new Date();
        expiredTime.setTime(10);
        ticket.setExpiredAt(expiredTime);
        return ticket;
    }
}