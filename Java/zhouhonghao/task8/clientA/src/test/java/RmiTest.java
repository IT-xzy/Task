import com.jns.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiTest {
    @Test
    public void shouldAnswerWithTrue() {
        //StudentService studentService = new RmiService().getStudentService();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        long time=System.currentTimeMillis();
        for(int i1=0;i1<100;i1++){
            int i=301;
            for(int j=0;j<10;j++){
                System.out.println(studentService.get(i));
                i++;
            }
        }
        time=System.currentTimeMillis()-time;
        System.out.println("本地调用总的时间: "+time+"ms"+"  "+time/1000+"s");
        //UsersService usersService= new RmiService().getUsersService();
        //Users users=usersService.getByPhone("15093750300");
        //System.out.println(users);
    }
}