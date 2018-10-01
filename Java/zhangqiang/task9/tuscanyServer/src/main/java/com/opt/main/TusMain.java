package com.opt.main;

import com.opt.controller.TuscanyListener;
import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.sql.ResultSet;

public class TusMain {
    private static Logger logger = Logger.getLogger(TusMain.class);
    public static void main(String[] args) {
        logger.info("main 启动tuscanyService服务");
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
//        System.setProperty("java.rmi.server.hostname", "47.98.50.21");
        Node node = NodeFactory.newInstance().createNode("tuscany/Computer.composite");
        node.start();
        logger.info("发布tuscanyService服务成功！");

    }
}
