package com.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TokenVarify {

    static Logger logger = (Logger) LoggerFactory.getLogger(TokenVarify.class);
    public static boolean doVarify(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        boolean isCookie=false;
        //获取cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        String id =null;
        String logtime = null;
        String token = null;
        if(cookies!=null) {
            //获取需要字段的值
            for (Cookie c : cookies) {
                //得到id字段的值
                if (c.getName().equals("id"))
                    id = c.getValue();
                //得到logtime字段的值
                if (c.getName().equals("logtime"))
                    logtime = c.getValue();
                //得到token字段的值
                if (c.getName().equals("token")) {
                    token = c.getValue();
                }
            }
        }else{
            return false;
        }
        //使用DES加密id和logtime字段，然后和token字段对比。
        //生成token
        String newtoken = ProduceToken.getToken(id,logtime);
        //如果相同，说明cookie有效
        if(newtoken.equals(token)){
            logger.info("token验证通过");
            isCookie =true;
        }
        //Cookie信息确认错误
        if(!isCookie){
            //用户没有登陆过
            httpServletRequest.setAttribute("message","请先登陆后再访问网站");
            //httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest,httpServletResponse);
            return false;
        }else{
            //用户登陆过，验证通过
            httpServletRequest.setAttribute("message","已登陆");
            return true;
        }

    }
}
