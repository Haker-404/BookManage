package com.cuit.bookmanage.biz;

import com.cuit.bookmanage.model.Ticket;
import com.cuit.bookmanage.model.Users;
import com.cuit.bookmanage.model.exception.LoginRegisterException;
import com.cuit.bookmanage.service.TicketService;
import com.cuit.bookmanage.service.UsersService;
import com.cuit.bookmanage.utils.ConcurrentUtils;
import com.cuit.bookmanage.utils.MD5;
import com.cuit.bookmanage.utils.TicketUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/27 20:17
 * @Version 1.0
 **/
@Service
public class LoginBiz {
    @Autowired
    private UsersService usersService;

    @Autowired
    private TicketService ticketService;

    private Logger logger = Logger.getLogger(LoginBiz.class);
    /**
     * 登录逻辑，先检查邮箱和密码，然后更新t票。
     * @return 返回最新t票
     * @throws Exception 账号密码错误
     */
    public String login(String email, String password) throws Exception {
        Users user = usersService.selectByEmail(email);
        //登录信息检查
        if (user == null)
            {throw new LoginRegisterException("邮箱不存在");}
        if(!StringUtils.equals(MD5.next(password),user.getPassword()))
            {throw new LoginRegisterException("密码不正确");}
        //检查ticket
        Ticket t = ticketService.selectByUserid(user.getId());
        //如果没有t票。生成一个
        if(t == null){
            t = TicketUtils.next(user.getId());
            ticketService.insert(t);
            return t.getTicket();
        }
        //是否过期
        if(t.getExpiredAt().before(new Date())){
            //删除
            ticketService.deleteByPrimaryKey(t.getId());
        }
        t = TicketUtils.next(user.getId());
        ticketService.insert(t);
        return t.getTicket();
    }
    /**
     * 用户退出登录，只需要删除数据库中用户的t票
     * @param t
     */
    public void logout(String t){
        ticketService.deleteByTicket(t);
    }
    /**
     * 注册一个用户，并返回用户t票
     *
     * @return 用户当前的t票
     */
    public String register(Users user) {
        //信息检查
        if (usersService.selectByEmail(user.getEmail()) != null) {
            throw new LoginRegisterException("用户邮箱已经存在！");
        }
        //密码加密
        String plain = user.getPassword();
        String md5 = MD5.next(plain);
        user.setPassword(md5);
        //数据库添加用户
        usersService.insert(user);
        //生成用户t票
        Ticket ticket = TicketUtils.next(user.getId());
        //数据库添加t票
        ticketService.insert(ticket);
        ConcurrentUtils.setHost(user);
        return ticket.getTicket();
        }
}

