import com.jns.entity.Users;
import com.jns.service.StudentService;
import com.jns.service.UsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiTest {
    @Test
    public void shouldAnswerWithTrue() {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
   //StudentService studentService = new RmiService().getStudentService();
        StudentService studentService = (StudentService) context.getBean("studentService");
    System.out.println("学生的人数:"+studentService.total());
       // UsersService usersService= new RmiService().getUsersService();
       UsersService usersService= (UsersService) context.getBean("usersService");
        Users users=usersService.getByPhone("15093750300");
        System.out.println(users);
    }
}