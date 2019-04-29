package com.cuit.bookmanage.service;


import com.cuit.bookmanage.model.Users;
import org.springframework.stereotype.Service;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:14
 * @Version 1.0
 **/
public interface UsersService {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByEmail(String email);
}
