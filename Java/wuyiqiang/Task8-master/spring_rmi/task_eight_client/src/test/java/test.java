import org.wyq.task.service.BaseService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class test {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        BaseService sca = (BaseService) Naming.lookup("rmi://127.0.0.1:8888/Sca1");
        System.out.println(sca);
    }
}
