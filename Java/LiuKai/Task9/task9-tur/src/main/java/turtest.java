import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import server.Calculator;
import server.ICalculator;

public class turtest {

    public static void main(String[] args) {
        Node node=NodeFactory.getInstance().createNode("Calculator.composite");
         node.start();
//        ICalculator c=node.getService(Calculator.class,"CalculatorServiceComponent");
//        System.out.println("c.add(2,2) = " + c.add(2,2));
        System.out.println("service start");
//        node.stop();

    }
}
