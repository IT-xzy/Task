package task8_service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JobServiceTest {
    @Resource(name = "jobService-2")
    private JobService jobService;

    @Test
    public void queryService() {
        System.out.println(jobService.queryService("后端开发"));
    }
}