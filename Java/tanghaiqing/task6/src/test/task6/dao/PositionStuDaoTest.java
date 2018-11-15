package task6.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task6.pojo.PositionStu;

import javax.annotation.Resource;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PositionStuDaoTest {
    @Resource(name = "positionStuDao")
    private PositionStuDao positionStuDao;

    @Test
    public void queryPosition() {
        PositionStu positionStu =positionStuDao.queryPosition(1);
        System.out.println(positionStu);
    }
}