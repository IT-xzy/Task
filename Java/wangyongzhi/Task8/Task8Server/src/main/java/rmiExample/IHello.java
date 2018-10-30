package rmiExample;

import java.rmi.Remote;
/**
 * @Description: 原生RMI测试之远程接口
 */
public interface IHello extends Remote {
    public String sayHello(String name) throws java.rmi.RemoteException;
}
