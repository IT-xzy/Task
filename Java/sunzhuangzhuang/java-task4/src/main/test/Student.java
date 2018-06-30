import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.OccupationDao;
import spring.dao.StudentDao;
import spring.model.Occupation;

import java.util.List;

public class Student {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        System.out.println(studentDao.getPm());

    }
    @Test
    public void O(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OccupationDao occupationDao = applicationContext.getBean(OccupationDao.class);
        List<Occupation> list = occupationDao.query();
        for (Occupation occupation:list) {
            System.out.println(occupation);
        }
    }
}
