package task05.dao;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task05.pojo.UserLogin;

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

}