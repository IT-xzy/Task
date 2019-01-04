package task6_redis.redis_cached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task6_redis.pojo.PositionStu;

import javax.annotation.Resource;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionStuRedisImplTest {
    @Resource(name = "positionStuRedisImpl")
    private PositionStuRedis positionStuRedis;

    @Test
    public void queryPosiM() {
        PositionStu positionStu =positionStuRedis.queryPosiM(13);
        System.out.println(positionStu);
        //Thread t1 = new Thread() {
        //    @Override
        //    public void run() {
        //        PositionStu positionStu = positionStuRedis.queryPosiM(12);
        //        System.out.println(positionStu);
        //    }
        //};
        //Thread t2 = new Thread() {
        //    @Override
        //    public void run() {
        //        PositionStu positionStu = positionStuRedis.queryPosiM(12);
        //        System.out.println(positionStu);
        //    }
        //};
        //t1.start();
        //t2.start();
    }
}