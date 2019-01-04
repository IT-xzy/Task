package task6_redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task6_redis.pojo.PositionStu;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionServiceTest {
    @Resource(name = "positionServiceImplR")
    private PositionService positionService;

    @Test
    public void goodShowService() {
        List<PositionStu> list =positionService.goodShowService();
        for(PositionStu p:list){
            System.out.println(p);
        }
    }
}