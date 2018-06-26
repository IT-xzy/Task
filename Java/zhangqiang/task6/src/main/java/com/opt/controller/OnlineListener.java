package com.opt.controller;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @Title: 监听器
 * @Description: 监听在线人数
 * @author By.ZhangQiang
 * @date 2018-5-29
 */
@WebListener
public class OnlineListener implements HttpSessionListener {

    private final Logger logger = Logger.getLogger(OnlineListener.class);
    private static int onlineTotal = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlineTotal ++;
        se.getSession().getServletContext().setAttribute("onlineT",onlineTotal);
        logger.info("\n监听器 监听到创建了一个session，当前session ： " + onlineTotal + "个");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        onlineTotal --;
        se.getSession().getServletContext().setAttribute("onlineT",onlineTotal);
        logger.info("\n监听器 监听到销毁了一个session 当前session ： " + onlineTotal + "个");
    }



}

