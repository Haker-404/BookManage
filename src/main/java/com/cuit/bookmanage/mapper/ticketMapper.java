package com.cuit.bookmanage.mapper;

import com.cuit.bookmanage.model.Ticket;
import org.springframework.stereotype.Repository;
@Repository
public interface ticketMapper {

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