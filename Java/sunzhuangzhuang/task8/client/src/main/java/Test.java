import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.IstudentService;

public class Test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IstudentService studentService = applicationContext.getBean(IstudentService.class);
        System.out.println(studentService.getAll());
    }
}
