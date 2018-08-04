import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.StudentDao;
import spring.service.impl.OccupationService;
import spring.service.impl.StudentService;


public class T {
    @Test
    public void TT(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = applicationContext.getBean(StudentService.class);
        System.out.println(studentService.getAll());
        System.out.println(studentService.getJava());
        System.out.println(studentService.getOffer());
        System.out.println(studentService.getWeb());
        System.out.println(studentService.getPm());
        System.out.println(studentService.getGood());
        OccupationService occupationService = applicationContext.getBean(OccupationService.class);
        System.out.println(occupationService.query());

    }
}
