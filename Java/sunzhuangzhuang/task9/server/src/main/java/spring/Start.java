package spring;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import spring.calculator.Calculator;
import spring.calculator.CalculatorImpl;

public class Start {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("tuscany服务启动");
//        Calculator calculator = node.getService(CalculatorImpl.class,"CalculatorServiceComponent");
//        System.out.println(calculator.plus(9,9));
//        System.out.println(calculator.reduce(70,60));
//        System.out.println(calculator.ride(60,60));
//        System.out.println(calculator.except(60,60));
//        node.stop();
    }
}
