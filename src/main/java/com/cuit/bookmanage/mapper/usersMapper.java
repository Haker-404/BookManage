package com.cuit.bookmanage.mapper;

import com.cuit.bookmanage.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface usersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByEmail(String email);
}