package task07.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task07.pojo.UserLogin;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class UserLoginDaoTest {
    @Resource
    private UserLoginDao userLoginDao;

    @Test
    public void login() {
//        userLogin.setName("AA");
//        System.out.println("1111111111111111");
        UserLogin u = new UserLogin();
        u.setName("AA");
        System.out.println(userLoginDao.login(u).toString());
    }

    @Test
    public void register() {
        System.out.println("111111111111111");
        UserLogin u = new UserLogin();
        u.setName("ZZ");
        u.setPassword("ADSDA");
        System.out.println(u.toString());
        System.out.println("22222222222222222222");
        userLoginDao.register(u);
//        System.out.println(userLoginDao.register(u));
    }

    @Test
    public void queryByName(){
        System.out.println("3333333333333333");
        System.out.println(userLoginDao.queryByName("12").toString());
    }

    @Test
    public void registerQueryName(){
        System.out.println("5555555555555");
        System.out.println(userLoginDao.registerQueryName("12"));

    }

    @Test
    public void registerQueryPhoneNumber(){
        System.out.println("5555555555555");
        System.out.println(userLoginDao.registerQueryPhoneNumber("12"));

    }

    @Test
    public void registerQueryEmail(){
        System.out.println("5555555555555");
        System.out.println(userLoginDao.registerQueryEmail("12"));

    }

    @Test
    public void insertHeadPhoto(){
        System.out.println("666666666666666666666");
        userLoginDao.updateHeadPhoto("红豆出南国" ,"12345.jpg");
    }



}