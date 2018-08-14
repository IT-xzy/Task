package com.opt.controller;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.rmi.RemoteException;

//@WebListener
public class TuscanyListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(TuscanyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("启动tuscanyService服务");
//        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        System.setProperty("java.rmi.server.hostname", "47.98.50.21");
//        System.setProperty("java.rmi.server.hostname", "119.29.17.188");
        Node node = NodeFactory.newInstance().createNode("tuscany/Computer.composite");
        node.start();
        logger.info("发布tuscanyService服务成功！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
