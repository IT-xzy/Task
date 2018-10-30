package tuscanyTest;

import org.apache.tuscany.sca.Node;
import org.apache.tuscany.sca.TuscanyRuntime;
import org.oasisopen.sca.NoSuchServiceException;
import tuscanyTest.impl.CalculatorServiceImpl;
import tuscanyTest.service.CalculatorService;

public class StartService2 {
    public static void main(String[] args) throws NoSuchServiceException {
        Node node = TuscanyRuntime.runComposite("Calculator.composite", "target/classes");
        try {
            System.out.println("service启动");
            //通过节点获取服务组件，从而生成服务组件实例
            // 第一个参数是服务组件实现类的类对象，第二个参数是Calculator.composite中的合成组件名
            CalculatorService calculator = node.getService(CalculatorService.class, "CalculatorServiceComponent");
            //通过服务组件实例调用在里面注册过的方法从而调用具体方法
            //在这里调用的add不是reference的name而是里面注册过的方法
            System.out.println(calculator.add(2, 3));
            System.out.println(calculator.multiply(2, 3));
        } finally

        {
            node.stop();
        }
    }
}


