import com.zyq.service.ExcellentStudentService;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServiceTest {

    @Test
    public void StudentServiceTest() throws RemoteException, NotBoundException, MalformedURLException {
        ExcellentStudentService excellentStudentService = (ExcellentStudentService) Naming.lookup("rmi://192.144.168.41:8099/ExcellentStudentService");
        System.out.println(excellentStudentService.selectByOrder().size());
    }
}
