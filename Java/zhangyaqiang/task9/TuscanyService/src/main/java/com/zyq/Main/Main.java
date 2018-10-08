package com.zyq.Main;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "192.144.168.41");
        Node node = NodeFactory.newInstance().createNode("calculator.composite");
        node.start();
        System.out.println("service启动");
    }
}
