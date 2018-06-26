package com.fangyuyang.subsidiary.encrption;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class Encript {
    public void encript(String name, HttpServletResponse response){
        Logger logger = LoggerFactory.getLogger(Encript.class);
        try {
            DES des = new DES();
            Long date = new Date().getTime();
            String currentTime = String.valueOf(date);
            String encName = des.encryptDES(name);//加密
            String encDate = des.encryptDES(currentTime);
            Cookie userNameCookie = new Cookie("loginUserName", encName);
            response.addCookie(userNameCookie);
            Cookie dateCookie = new Cookie("loginDate", encDate);
            response.addCookie(dateCookie);
        }catch (Exception e){
           e.printStackTrace();
        }

}
}
