package test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Job;
import service.Servicejob;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class ServiceJobImplTest {
    @Autowired
    Servicejob servicejob;
    @Test
    public void testListStudent() throws Exception {
        List<Job> studentList=servicejob.listJob();
        System.out.println(studentList);
    }
}