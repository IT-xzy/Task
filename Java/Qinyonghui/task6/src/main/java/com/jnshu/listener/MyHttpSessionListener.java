/*
package com.jnshu.listener;

import com.jnshu.entity.People;
import com.jnshu.myutils.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private int num = 0;//统计人数

    public void sessionCreated(HttpSessionEvent se) {
        num++;
        se.getSession().getServletContext().setAttribute("number", num);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        num--;
        se.getSession().getServletContext().setAttribute("number", num);
        //在此用户被销毁的时候，将链表中对应的用户对象删除
        ArrayList<People> userlist = (ArrayList<People>) se.getSession().getServletContext().getAttribute("userlist");
        if (SessionUtil.getUserBySessionID(userlist, se.getSession().getId()) != null) {
            userlist.remove(SessionUtil.getUserBySessionID(userlist, se.getSession().getId()));
        }
    }
}

*/
