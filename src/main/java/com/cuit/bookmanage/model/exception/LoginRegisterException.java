package com.cuit.bookmanage.model.exception;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/27 20:29
 * @Version 1.0
 **/
public class LoginRegisterException extends RuntimeException{
    public LoginRegisterException(String message) {
        super(message);
    }
    public LoginRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
    public LoginRegisterException(Throwable cause) {
        super(cause);
    }
}
