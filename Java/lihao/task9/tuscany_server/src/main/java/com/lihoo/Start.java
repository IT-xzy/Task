package com.lihoo;

import com.lihoo.calculator.Calculator;
import com.lihoo.calculator.CalculatorImpl;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * Hello world!
 *
 */
public class Start {

    public static void main(String[] args) {
        Node node = NodeFactory.newInstance()
                .createNode("Calculator.composite");
        node.start();
        System.out.println("Tuscany服务启动中...");
        Calculator calculator = node.getService(CalculatorImpl.class,"CalculatorServiceComponent");
        System.out.println(calculator.add(2,2));
        System.out.println(calculator.subtract(2,2));
        System.out.println(calculator.multiply(2,2));
        System.out.println(calculator.divide(2,2));
        node.stop();
    }
}
