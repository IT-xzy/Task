package task9.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionServiceTest {
    @Resource(name = "positionServiceImpl")
    private PositionService positionService;

    @Test
    public void goodShowService() {
        System.out.println(positionService.goodShowService());
    }
}