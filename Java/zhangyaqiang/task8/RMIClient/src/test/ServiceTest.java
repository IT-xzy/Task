import com.zyq.pojo.Student;
import com.zyq.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

    @Test
    public void StudentServiceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        Student student = studentService.selectById(60L);
        System.out.println(student);
    }
}
