package com.ptteng;


import com.ptteng.entity.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * @ClassName Listenter
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/18  21:21
 * @Version 1.0
 **/
public class Listener implements HttpSessionListener {
    public static int count = 0;

    @Override
    //session创建时执行
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("新建会话===============================");
        count++;
        httpSessionEvent.getSession().setAttribute("count", count);

    }

    @Override
    //session销毁时执行
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        httpSessionEvent.getSession().setAttribute("count", count);


    }
    //获取活动的session个数(在线人数)
    public static int getActiveSessions() {
        return count;

    }}
