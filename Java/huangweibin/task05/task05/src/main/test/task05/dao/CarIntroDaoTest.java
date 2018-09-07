package task05.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task05.pojo.CarIntro;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-dao.xml")
public class CarIntroDaoTest {

    @Resource
    private CarIntroDao carIntroDao;

    @Test
    public void queryAllIntro() {
        System.out.println("999999999999999999");
        List<CarIntro> carIntroList = carIntroDao.queryAllIntro();
        System.out.println(carIntroList.toString());

    }
}