package com.ev;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class TestMain {
    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        node.start();
    }
}
