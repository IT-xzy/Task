package task05.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task05.pojo.Students;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class StuDaoTest {
    @Resource
    private StuDao stuDao;

    @Test
    public void querySum() {
        System.out.println("111111111111111111111");
        System.out.println(stuDao.querySum());
    }

    @Test
    public void queryWorkSum() {
        System.out.println("111111111111111111111");
        System.out.println(stuDao.queryWorkSum());
    }

    @Test
    public void queryFront(){
        System.out.println("12212121222222222");
//        System.out.println(stuDao.queryFront().toString());
        List<Students> listFront = stuDao.queryFrontList();
        System.out.println(listFront.toString());

    }

    @Test
    public void queryWorkSum1() {
        String a ="工作";
        System.out.println("111111111111111111111");
        System.out.println(stuDao.queryWorkSum1(a));
    }
}