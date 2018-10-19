package tuscanyTest;

import tuscanyTest.service.CalculatorService;

import java.rmi.Naming;
/**
 * @Description: 调用远程服务
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        CalculatorService calculator = (CalculatorService) Naming.lookup("//127.0.0.1:9090/CalculatorRMIService");
        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.multiply(2, 3));
    }
}
