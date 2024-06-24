package com.jnshu;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class Begin {

    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();
        System.out.println("服务已启动!");
    }
}
