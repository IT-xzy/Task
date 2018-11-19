package task8_service.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task8_service.pojo.User;
import task8_service.util.MD5Utils;

import javax.annotation.Resource;



@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void saveUser() {
        User user =new User();
        user.setUserID(1);
        user.setUserName("唐海清");
        user.setAge(22);
        user.setAdminCode("1015320765");
        user.setPassword(MD5Utils.getSaltMD5("1456987"));
        user.setTelephone("17688432366");
        user.setEmailaccount("1015320765@qq.com");
        user.setCreatTime(System.currentTimeMillis());
        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void queryUser() {
        User user =userDao.queryUser("1015320765");
        System.out.println(user);
    }
}