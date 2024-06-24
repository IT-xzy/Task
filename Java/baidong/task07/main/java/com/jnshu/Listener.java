package com.jnshu;

import com.jnshu.controller.UserController;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {
    private static final Logger logger = Logger.getLogger(Listener.class);

    public  static int count = 0;

//    session创建的时候执行

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("开始监听========");
        System.out.println("开始监听========");
        count++;
        httpSessionEvent.getSession().setAttribute("count", count);

    }
//session 销毁的时候创建
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("开始销毁========");
        System.out.println("开始销毁========");
        count--;
        httpSessionEvent.getSession().setAttribute("count", count);
    }
//    获取在线人数
    public static int getActiveSessions(){
        return count;
    }
}

