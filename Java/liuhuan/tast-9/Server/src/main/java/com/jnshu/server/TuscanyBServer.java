package com.jnshu.server;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: ServerA
 * @description: ServerA
 * @author: Mr.xweiba
 * @create: 2018-06-17 21:41
 **/

public class TuscanyBServer {
    private static Logger logger = LoggerFactory.getLogger(TuscanyBServer.class);
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "93.179.100.194");
        Node node = NodeFactory.newInstance().createNode("tuscany/tuscanyB.composite");
        node.start();
        logger.debug("TuscanyServer 已启动 ");
    }
}
