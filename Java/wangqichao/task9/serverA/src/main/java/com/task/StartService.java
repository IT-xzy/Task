package com.task;

import com.task.tuscany.server.Calculator;
import com.task.tuscany.server.ICalculator;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartService {
    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode(
                "Calculator.composite");
        node.start();
        System.out.println("service启动");
//        ICalculator c = node.getService(Calculator.class,
//                "CalculatorServiceComponent");
//        System.out.println(c.add(2, 2));
//        node.stop();
    }
}
