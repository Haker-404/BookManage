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
    public int deleteByPrimaryKey(Long id) {
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
    public Ticket selectByPrimaryKey(Long id) {
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
}
