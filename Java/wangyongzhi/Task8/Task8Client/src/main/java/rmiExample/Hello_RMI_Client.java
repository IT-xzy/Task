package rmiExample;

import java.rmi.Naming;
/**
 * @Description: 原生RMI测试之客户端调用服务端
 */
public class Hello_RMI_Client {
    public static void main(String[] args){
        try{
            IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
            System.out.println(hello.sayHello("tiemuer"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
