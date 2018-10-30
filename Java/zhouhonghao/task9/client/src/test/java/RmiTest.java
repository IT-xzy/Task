import com.jns.entity.Users;
import com.jns.service.StudentService;
import com.jns.service.UsersService;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiTest {
    @Test
    public void shouldAnswerWithTrue() throws RemoteException, NotBoundException, MalformedURLException {
   // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
   ////StudentService studentService = new RmiService().getStudentService();
   //     StudentService studentService = (StudentService) context.getBean("studentService");
   // System.out.println("学生的人数:"+studentService.total());
   //    // UsersService usersService= new RmiService().getUsersService();
   //    UsersService usersService= (UsersService) context.getBean("usersService");
   //     Users users=usersService.getByPhone("15093750300");
   //     System.out.println(users);
        StudentService studentService= (StudentService) Naming.lookup("rmi://139.199.126.254:8083/StudentServer");
        System.out.println("学生的人数:"+studentService.total());
        UsersService usersService= (UsersService) Naming.lookup("rmi://139.199.126.254:8083/UsersServer");
        Users users=usersService.getByPhone("15093750300");
        System.out.println("学生信息："+users);
    }
}