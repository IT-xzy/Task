package com.xiaobo.demo.listener;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class TuscanyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.setProperty("java.rmi.server.hostname","182.61.19.92");
        Node node= NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("service启动");

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
