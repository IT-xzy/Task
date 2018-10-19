package com.student.rmi;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartService {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Tuscany.composite");
        node.start();

        System.out.println("tuscany service启动");
    }
}