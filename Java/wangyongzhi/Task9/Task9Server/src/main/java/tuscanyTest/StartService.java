package tuscanyTest;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;
import tuscanyTest.impl.CalculatorServiceImpl;
import tuscanyTest.service.CalculatorService;
/**
 * @Description: 启动远程服务方式1
 */
public class StartService {
    public static void main(String[] args){
        //创建Node工厂实例，通过工厂实例加载配置文件Calculator.composite
        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
        //启动节点
        node.start();
        System.out.println("service启动");

        //通过节点获取服务组件，从而生成服务组件实例
        // 第一个参数是服务组件实现类的类对象，或者是spring的接口；第二个参数是Calculator.composite中的合成组件名
        CalculatorService calculator = node.getService(CalculatorService.class, "CalculatorServiceComponent");
        //通过服务组件实例调用在里面注册过的方法从而调用具体方法
        //在这里调用的add不是reference的name而是里面注册过的方法
        System.out.println(calculator.add(2,3));
        System.out.println(calculator.multiply(2,3));
        node.stop();
    }
}
