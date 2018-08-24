package com.myServer;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServer {

    private static final Logger logger=Logger.getLogger(MyServer.class);

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        node.start();
        logger.info("启动服务 no.0");
    }
}
