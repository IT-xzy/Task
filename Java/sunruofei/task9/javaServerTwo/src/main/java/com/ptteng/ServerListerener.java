package com.ptteng;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName ServerListerener
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/26  23:56
 * @Version 1.0
 **/
public class ServerListerener implements ServletContextListener{
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
