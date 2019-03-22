package com.suger.Main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * @author suger
 * @date 2019/1/2 20:35
 */
public class TuscanyServer {

    public static void main(String[] args) {

        System.setProperty("java.rmi.server.hostname", "172.27.0.6");
        Node node = NodeFactory.getInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("服务端启动");
        //node.stop();
    }
}
