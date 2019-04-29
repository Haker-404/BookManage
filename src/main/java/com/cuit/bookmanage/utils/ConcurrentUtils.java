package com.cuit.bookmanage.utils;

import com.cuit.bookmanage.model.Users;
import org.springframework.stereotype.Service;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/29 19:29
 * @Version 1.0
 **/
public class ConcurrentUtils {
    private static ThreadLocal<Users> host = new ThreadLocal<>();

    public static Users getHost(){
        return host.get();
    }

    public static void setHost(Users user){
        host.set(user);
    }

}