package com.cuit.bookmanage.service;


import com.cuit.bookmanage.model.Ticket;
import org.springframework.stereotype.Service;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:13
 * @Version 1.0
 **/
public interface TicketService {
    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    Ticket selectByUserid(Integer userid);

    int deleteByTicket(String ticket);

    Ticket selectByTicket(String ticket);

}
