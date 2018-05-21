package com.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartService1198 {

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Tuscany1198.composite");
        node.start();
        System.out.println("tuscany service1198启动");
    }
}
