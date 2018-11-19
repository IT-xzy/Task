package task8_service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;




@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;


    @Test
    public void countService() {
        Integer i=studentService.countService();
        System.out.println(i);

    }

    @Test
    public void countJobService() {
        Integer j =studentService.countJobService();
        System.out.println(j);
    }
}