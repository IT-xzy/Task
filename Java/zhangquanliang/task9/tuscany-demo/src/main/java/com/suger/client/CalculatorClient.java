package com.suger.client;

import com.suger.service.CalculatorService;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

/**
 * @author suger
 * @date 2019/1/6 19:14
 */
public class CalculatorClient {

    public static void main(String[] args) throws Exception {

       //  SCADomain scaDomain = SCADomain.newInstance("Calculator.composite");
        //  CalculatorService calculatorService = scaDomain.getService(CalculatorService.class, "CalculatorComponent");

       Node node = NodeFactory.getInstance().createNode("Calculator.composite");
       node.start();
       System.out.println("服务端启动");

       CalculatorService  calculatorService = node.getService(CalculatorService.class,"CalculatorComponent");

        System.out.println("3 + 2=" + calculatorService.add(3, 2));
        System.out.println("3 - 2=" + calculatorService.subtract(3, 2));
        System.out.println("3 * 2=" + calculatorService.multiply(3, 2));
        System.out.println("3 / 2=" + calculatorService.divide(3, 2));

        node.stop();

    }
}
