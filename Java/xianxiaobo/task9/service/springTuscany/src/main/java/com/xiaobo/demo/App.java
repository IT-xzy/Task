package com.xiaobo.demo;


import com.xiaobo.demo.service.Calculator;
import com.xiaobo.demo.service.ICalculator;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class App {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode(
                "Calculator.composite");
        node.start();
        System.out.println("service启动");
    }
}
