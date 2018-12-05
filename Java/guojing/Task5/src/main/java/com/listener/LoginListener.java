package com.listener;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginListener implements HttpSessionListener, HttpSessionAttributeListener {

    static Logger logger = Logger.getLogger(LoginListener.class);


    //监听http会话中的属性添加
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //增加一个用户
        UserList.addUser(String.valueOf(se.getValue()));
        //   打印参数
        logger.info("session(" + se.getSession().getId() + ")增加属性" + se.getName() + ",值为" + se.getValue());
    }

    //    监听http会话中的属性移除
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        UserList.removeUser(String.valueOf(se.getValue()));
        logger.info(se.getValue() + "属性已移除");
    }

    //    监听http会话中的属性更改操作
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String oldValue = String.valueOf(se.getValue());//旧的属性
        String newValue = String.valueOf(se.getSession().getAttribute(se.getName()));//新的属性
        UserList.removeUser(oldValue);//移除旧的属性
        UserList.addUser(newValue);//增加新的属性
        logger.info(oldValue + "属性已更改为" + newValue);
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("会话已经创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("会话已经销毁");
    }
}


