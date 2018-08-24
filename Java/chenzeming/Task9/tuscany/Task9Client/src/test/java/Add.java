import com.jnshu.czm.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Add {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

//        UserService c = (UserService) Naming.lookup("rmi://127.0.0.1:8088/UserService");
        UserService c = (UserService) Naming.lookup("rmi://127.0.0.1:8089/UserService");
        c.test();

    }
}
