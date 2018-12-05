package com.jnshu.listener;

import com.jnshu.myutils.CountUtils;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerTest implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent se){
        //在线人数+1
        CountUtils.add();
    }
    public void sessionDestroyed(HttpSessionEvent se){
        //在线人数-1
        CountUtils.subtract();
    }
}
