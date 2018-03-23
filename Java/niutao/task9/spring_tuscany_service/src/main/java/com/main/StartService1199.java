package com.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartService1199 {

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Tuscany1199.composite");
        node.start();
        System.out.println("tuscany service1199启动");
    }
}
