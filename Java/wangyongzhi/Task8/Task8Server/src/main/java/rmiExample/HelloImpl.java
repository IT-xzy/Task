package rmiExample;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
/**
 * @Description: 原生RMI测试之远程接口实现类
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    private static final long serialVersionUID = 4077329331699640331L;

    // 这个实现必须有一个显式的构造函数，并且要抛出一个RemoteException异常
    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello!  " + name + "  ^_^";
    }

    public static void main(String[] args) {
        try {
            IHello hello = new HelloImpl();
            LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("rmi://localhost:1099/hello", hello);
            System.out.print("Ready......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
