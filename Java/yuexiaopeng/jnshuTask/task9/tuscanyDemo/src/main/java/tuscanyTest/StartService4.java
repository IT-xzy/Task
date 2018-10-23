package tuscanyTest;


import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class StartService4 {

    public static void main(String[] args) {
        //加载配置文件
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("service启动");
        Calculator calculator = node.getService(Calculator.class, "CalculatorServiceComponent");
        System.out.println(calculator.add(2, 3));
        node.stop();
    }
}
