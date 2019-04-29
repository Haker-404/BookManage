package com.cuit.bookmanage.service.Impl;

import com.cuit.bookmanage.mapper.usersMapper;
import com.cuit.bookmanage.model.Users;
import com.cuit.bookmanage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:49
 * @Version 1.0
 **/
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private usersMapper usersMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return 0;
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public Users selectByEmail(String email) {
        return usersMapper.selectByEmail(email);
    }
}
