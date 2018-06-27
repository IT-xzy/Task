package action;

import org.apache.tuscany.sca.node.NodeFactory;
import service.CalculatorService;
import service.impl.CalculatorServiceImpl;

public class TuscanyServerAction {
    public static void main(String[] args) {
        org.apache.tuscany.sca.node.Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("tuscany服务启动");
//        CalculatorService calculatorService = node.getService(CalculatorService.class,"CalculatorServiceComponent");
//        System.out.println(calculatorService.add(3,4));
//        node.stop();
    }
}
