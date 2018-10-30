package com.task5.main;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.io.IOException;
import java.rmi.server.RMISocketFactory;

public class Test {
    public static void main(String[] args) throws IOException {
        System.setProperty("java.rmi.server.hostname","192.144.168.41");
//        RMISocketFactory.setSocketFactory(new SMRMISocket());
        Node node = NodeFactory.newInstance().createNode("calculator.composite");
        node.start();
        System.out.println("服务器已启动");
    }
}
