import org.junit.Test;
import org.junit.Before; 
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Job;
import pojo.Student;
import service.ServiceIndex;
import service.Servicejob;

import javax.xml.ws.Service;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class ServiceIndexImplTest {
    @Autowired
    ServiceIndex serviceIndex;
@Autowired
    Servicejob servicejob;
@Test
public void testListStudent() throws Exception {
    List<Student> studentList=serviceIndex.listStudent();
    System.out.println(studentList);
}
@Test
    public void testCount(){
    int i = serviceIndex.count();
    List<Job> jobList=servicejob.listJob();
    System.out.println(i);
    System.out.println(jobList);
}
} 
