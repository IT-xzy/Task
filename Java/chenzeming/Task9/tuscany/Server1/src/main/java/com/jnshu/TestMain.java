package com.jnshu;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {

    private static Logger logger= LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        logger.info("\nservice1 启动");
    }

}
