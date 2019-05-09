package com.cuit.bookmanage.interceptor;

import com.cuit.bookmanage.model.Ticket;
import com.cuit.bookmanage.service.TicketService;
import com.cuit.bookmanage.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * @Author: LiJingWen
 * @Date: 2019/4/29 19:56
 * @Version 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private TicketService ticketService;
    private Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("此处应该是对于所有经过/books/下的请求进行拦截判断：");
        //没有t票，去登陆
        String t = CookieUtils.getCookie("t",request);
        if(StringUtils.isEmpty(t)){
            response.sendRedirect("/users/login");
            return false;
        }
        //无效t票，去登陆
        Ticket ticket = ticketService.selectByTicket(t);
        if(ticket == null){
            response.sendRedirect("/users/login");
            return false;
        }
        //过期t票，去登陆
        if(ticket.getExpiredAt().before(new Date())){
            response.sendRedirect("/users/login");
            return false;
        }
        return true;
    }
}