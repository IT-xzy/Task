package action;

import service.CalculatorService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TuscanyClientAction {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        CalculatorService calculatorService = (CalculatorService) Naming.lookup("//127.0.0.1:9099/CalculatorRMIService");
        System.out.println("客户端调用输出");
        System.out.println(calculatorService.add(2,8));
    }
}
