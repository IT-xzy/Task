package com.fml.rmi;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Start implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("------开始启动RMI服务------");
        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("------RMI服务启动完成------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /*@Override
    public void init() throws ServletException {
        System.out.println("------开始启动RMI服务------");
        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("------RMI服务启动完成------");
    }

    public static void main(String[] args) throws InterruptedException {
        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("OK");
    }*/

}
