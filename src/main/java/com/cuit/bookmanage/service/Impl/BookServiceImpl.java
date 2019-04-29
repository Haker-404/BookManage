package com.cuit.bookmanage.service.Impl;

import com.cuit.bookmanage.mapper.bookMapper;
import com.cuit.bookmanage.model.Book;
import com.cuit.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:48
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private bookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(int id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public int updateStatusById(Book book) {
        return bookMapper.updateStatusById(book);
    }
}
