package com.cuit.bookmanage.service.Impl;

import com.cuit.bookmanage.mapper.ticketMapper;
import com.cuit.bookmanage.model.Ticket;
import com.cuit.bookmanage.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:49
 * @Version 1.0
 **/
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private ticketMapper ticketMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ticketMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Ticket record) {
        return ticketMapper.insert(record);
    }

    @Override
    public int insertSelective(Ticket record) {
        return 0;
    }

    @Override
    public Ticket selectByPrimaryKey(Integer id) {
        return ticketMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Ticket record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Ticket record) {
        return ticketMapper.updateByPrimaryKey(record);
    }

    @Override
    public Ticket selectByUserid(Integer userid) {
        return ticketMapper.selectByUserid(userid);
    }

    @Override
    public int deleteByTicket(String ticket) {
        return ticketMapper.deleteByTicket(ticket);
    }

    @Override
    public Ticket selectByTicket(String ticket) {
        return ticketMapper.selectByTicket(ticket);
    }
}
