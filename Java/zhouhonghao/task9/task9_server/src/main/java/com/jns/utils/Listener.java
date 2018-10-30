package com.jns.utils;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.setProperty("java.rmi.server.hostname","139.199.126.254");
        Node node=  NodeFactory.newInstance().createNode("server.composite");
        node.start();
        System.out.println("使用监听器，服务器端发布成功！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
