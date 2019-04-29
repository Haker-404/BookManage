package com.cuit.bookmanage.controller;

import com.cuit.bookmanage.biz.LoginBiz;
import com.cuit.bookmanage.model.Users;
import com.cuit.bookmanage.service.UsersService;
import com.cuit.bookmanage.utils.CookieUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/27 16:20
 * @Version 1.0
 **/
@Controller
public class usersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private LoginBiz loginBiz;

    private Logger logger = Logger.getLogger(usersController.class);

    @RequestMapping(value = "/users/register")
    public String register(){
        return "/login/register";
    }

    @RequestMapping(value = "/users/register/do")
    public String doregister(Model model,
                             HttpServletResponse response,
                             @RequestParam(value = "name")String name,
                             @RequestParam(value = "email")String email,
                             @RequestParam(value = "password")String password){
        Users users = new Users();
        users.setName(name);
        users.setEmail(email);
        users.setPassword(password);
        try {
            String t = loginBiz.register(users);
            CookieUtils.writeCookie("t", t, response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "/404";
        }
    }

    @RequestMapping(path = {"/users/logout/do"}, method = {RequestMethod.GET})
    public String doLogout(
            @CookieValue("t") String t
    ) {
        loginBiz.logout(t);
        return "redirect:/index";
    }



    @RequestMapping(value = "/users/login")
    public String login(){
        return "/login/login";
    }



    @RequestMapping(path = {"/users/login/do"}, method = {RequestMethod.POST})
    public String doLogin(
            Model model,
            HttpServletResponse response,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        try {
            String t = loginBiz.login(email, password);
            CookieUtils.writeCookie("t", t, response);
            logger.info("到此为验证成功，进入主界面");
            logger.info("获得秘钥"+t);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "404";
        }
    }

}
