package com.mutesaid;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class RMIServer {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        node.start();

        System.out.println("TuscanyServer 已启动 ");
    }

}
