package task8_service.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task8_service.pojo.PositionStu;

import javax.annotation.Resource;
import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionServiceTest {
    @Resource(name = "positionService-2")
    private PositionService positionService;

    @Test
    public void goodShowService() {
            List<PositionStu> positionStus = positionService.goodShowService();
            System.out.println(positionStus);
    }
}