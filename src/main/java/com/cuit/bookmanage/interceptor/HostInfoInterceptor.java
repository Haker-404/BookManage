package com.cuit.bookmanage.interceptor;

import com.cuit.bookmanage.model.Ticket;
import com.cuit.bookmanage.model.Users;
import com.cuit.bookmanage.service.TicketService;
import com.cuit.bookmanage.service.UsersService;
import com.cuit.bookmanage.utils.ConcurrentUtils;
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
 * @Date: 2019/4/29 19:46
 * @Version 1.0
 **/
@Component
public class HostInfoInterceptor implements HandlerInterceptor {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UsersService userService;

    private Logger logger = Logger.getLogger(HostInfoInterceptor.class) ;
    /**
     * 为注入host信息
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String t = CookieUtils.getCookie("t", request);
        logger.info("拦截器，在处理请求之前被调用："+t);
        if (!StringUtils.isEmpty(t)) {
            Ticket ticket = ticketService.selectByTicket(t);
            if (ticket != null && ticket.getExpiredAt().after(new Date())) {
                Users host = userService.selectByPrimaryKey(ticket.getUserId());
                ConcurrentUtils.setHost(host);
            }
        }
        return true;
    }
}
