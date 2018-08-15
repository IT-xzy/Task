package com.spring.test;

import com.spring.computer.CalculatorInterface;
import com.spring.computer.impl.Calculator;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class CalculatorServerClient {
	public static void main(String[] args) {
		Node node= NodeFactory.newInstance().createNode("Calculator.composite");
		node.start();
		System.out.println("service启动 ");
		CalculatorInterface calculatorInterface = node.getService(Calculator.class, "CalculatorServiceComponent");
		System.out.println(calculatorInterface.add(2, 2));
		System.out.println("3 + 2 = " + calculatorInterface.add(3, 2));
		System.out.println("3 - 2 = " + calculatorInterface.subtract(3, 2));
		System.out.println("3 * 2 = " + calculatorInterface.multiply(3, 2));
		System.out.println("3 / 2 = " + calculatorInterface.divide(3, 2));
		node.stop();
	}

}
