package com.cuit.bookmanage.mapper;

import com.cuit.bookmanage.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookMapper {
    int deleteByPrimaryKey(int id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAll();
    int updateStatusById(Book book);
}