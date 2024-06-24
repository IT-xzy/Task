package com.jnshu;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Begin implements ServletContextListener {

     @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("启动服务成功");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
