/*
package com.jnshu.listener;

import com.jnshu.entity.People;
import com.jnshu.myutils.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebListener
public class MyServeltRequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        ArrayList<People> userlist=null;
        //获取全局变量中的链表，若不存在，则创建一个新的链表
        userlist= (ArrayList<People>) sre.getServletContext().getAttribute("userlist");
        if (userlist == null) {
            userlist = new ArrayList<People>();
        }
        //获取request对象
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        //获取sessionID
        String sessionID = request.getSession().getId();
        //通过sessionID在链表中查找对象，若没有此对象，则创建加入到链表中
        if (SessionUtil.getUserBySessionID(userlist, sessionID) == null) {
            People user = new People();
            user.setSessionID(sessionID);
            user.setFirstTime(new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(new Date()));
            user.setIp(request.getRemoteAddr());
            userlist.add(user);
        }
        //将链表设置为全局变量
        sre.getServletContext().setAttribute("userlist", userlist);
    }
}
*/
