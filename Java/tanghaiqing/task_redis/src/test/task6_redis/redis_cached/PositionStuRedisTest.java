package task6_redis.redis_cached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task6_redis.pojo.PositionStu;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionStuRedisTest {
    @Autowired
    private PositionStuRedis positionStuRedis;

    @Test
    public void queryPositionStuR() {
        List<PositionStu> positionStus =positionStuRedis.queryPositionStuR();
        for (PositionStu p:positionStus){
            System.out.println(p.toString());
        }

    }

    @Test
    public void savePositionStuR() {
        PositionStu p=new PositionStu();
        p.setName("唐海清");
        p.setPosition("java后端工程师");
        p.setIntro("后端工程师是一个跟数据打交道的工作，所以一定要耐得住寂寞，在爬虫中寻找快乐！");
        p.setImage("242424");
        p.setSalary(5.5);
        p.setCreateTime(System.currentTimeMillis());
        p.setUpdateTime(System.currentTimeMillis());
        Integer i =positionStuRedis.savePositionStuR(p);
        System.out.println(i);
    }

    @Test
    public void queryPosiM() {

    }
}