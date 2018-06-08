package com.ssm.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TuscanyServer {
    private static final Logger logger = LoggerFactory.getLogger(TuscanyServer.class);

    public static void main(String[] args)  {
        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        node.start();
        logger.info("启动服务 no.1");
    }
}
