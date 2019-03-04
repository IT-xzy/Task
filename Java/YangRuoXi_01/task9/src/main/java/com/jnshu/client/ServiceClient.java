package com.jnshu.client;


import com.jnshu.service.Calculator;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class ServiceClient {

    public static void main(String[] args) {

        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        Calculator c = node.getService(Calculator.class,"ServiceClient");


        System.out.println("service启动");
        System.out.println(c.add(2, 2));
        System.out.println("3 + 2 = " + c.add(3, 2));
        System.out.println("3 - 2 = " + c.minus(3, 2));
        System.out.println("3 * 2 = " + c.time(3, 2));
        System.out.println("3 / 2 = " + c.divide(3, 2));
//        node.stop();



//        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
//        SCANode node = factory.createSCANodeFromClassLoader("Calculator.composite", CalculatorClient.class.getClassLoader());
//        node.start();
//
//        CalculatorService calculatorService = ((SCAClient)node).getService(CalculatorService.class, "CalculatorServiceComponent");
//
//        // Calculate
//        System.out.println("3 + 2=" + calculatorService.add(3, 2));
//        System.out.println("3 - 2=" + calculatorService.subtract(3, 2));
//        System.out.println("3 * 2=" + calculatorService.multiply(3, 2));
//        System.out.println("3 / 2=" + calculatorService.divide(3, 2));
    }
}
