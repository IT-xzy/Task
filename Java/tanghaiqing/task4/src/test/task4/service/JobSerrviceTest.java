package task4.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task4.pojo.Job;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JobSerrviceTest {
    @Resource(name = "jobServiceImpl")
    private JobService jobSerrvice;

    @Test
    public void queryService() {
        List<Job> jobs =jobSerrvice.queryService("后端开发");
        for(Job job:jobs){
            System.out.println(job);
        }
    }
}