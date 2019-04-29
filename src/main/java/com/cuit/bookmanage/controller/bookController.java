package com.cuit.bookmanage.controller;

import com.cuit.bookmanage.model.Book;

import com.cuit.bookmanage.model.Users;
import com.cuit.bookmanage.service.BookService;
import com.cuit.bookmanage.utils.ConcurrentUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import com.cuit.bookmanage.model.enums.BookStatusEnum;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/26 16:18
 * @Version 1.0
 **/
@Controller
public class bookController {

    private Logger logger = Logger.getLogger(bookController.class);

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/book/addbook",method = GET)
    public String addBook(){
        return "/book/addbook";
    }

    @RequestMapping(value = "/books/{bookId}/delete",method = GET)
    public ModelAndView deleteBook(@PathVariable("bookId")int bookId){
        Book book = new Book();
        book.setId(bookId);
        book.setStatus(BookStatusEnum.DELETE.getValue());
        bookService.updateStatusById(book);
        ModelAndView delmodel = new ModelAndView();
        delmodel.setViewName("/book/selectAll");
        return delmodel;
    }


    @RequestMapping(value = "/books/add/do",method = POST)
    public ModelAndView addBook(@RequestParam(value = "name",defaultValue = " ")String name,
                                @RequestParam(value = "author",defaultValue = " ")String author,
                                @RequestParam(value = "price",defaultValue = " ")String price){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setStatus(0);
        bookService.insert(book);
        ModelAndView model = new ModelAndView();
        model.setViewName("/book/selectAll");
        return model;

    }

    @RequestMapping(value = "/book/selectAll")
    public ModelAndView selectAllBook(){
        List<Book> books = new ArrayList<Book>();
        books = bookService.selectAll();
        ModelAndView model = new ModelAndView();
        model.addObject("books",books);

        Users host = ConcurrentUtils.getHost();

        if (host != null) {
            model.addObject("host", host);
        }
        model.setViewName("book/books");
        return model;

    }
    @RequestMapping(value = "/index")
    public String index(){
        return "redirect:/book/selectAll";

    }
}
