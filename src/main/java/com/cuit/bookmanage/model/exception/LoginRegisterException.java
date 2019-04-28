package com.cuit.bookmanage.model.exception;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/27 20:29
 * @Version 1.0
 **/
public class LoginRegisterException extends Exception{
    private String message;

    public LoginRegisterException(String message) {
        super(message);
        this.message = message;
    }

    public void getException(){
       System.out.println(message);
    }
}
