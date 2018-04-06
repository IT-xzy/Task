package com.ptteng.manager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //设置全局超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //多IP下的RMI调用，必须设置
        System.setProperty("java.rmi.server.hostname", "39.106.59.18");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
