package com.cuit.bookmanage.utils;

import java.util.UUID;

/**
 * @Author: LiJingWen
 * @Date: 2019/4/28 19:02
 * @Version 1.0
 **/
public class UuidUtils {
    public static String next(){
        return UUID.randomUUID().toString().replace("-","a");
    }
}