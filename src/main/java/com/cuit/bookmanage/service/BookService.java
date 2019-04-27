package com.cuit.bookmanage.service;

import com.cuit.bookmanage.model.Book;
import com.cuit.bookmanage.mapper.bookMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:11
 * @Version 1.0
 **/

public interface BookService  {
    int deleteByPrimaryKey(int id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAll();
}
