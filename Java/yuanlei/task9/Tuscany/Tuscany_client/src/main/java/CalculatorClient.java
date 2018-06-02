import server.Calculator;


import java.rmi.Naming;


public class CalculatorClient {
    public static void main(String[] args) throws Exception {
        Calculator c = (Calculator) Naming.lookup("//127.0.0.1:8099/CalculatorRMIService");
        System.out.println(c.add(3,4));
    }
}
