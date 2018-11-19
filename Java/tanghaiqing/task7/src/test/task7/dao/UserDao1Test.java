package task7.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task7.pojo.UserImpl;
import task7.util.MD5Utils;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDao1Test {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void updateUser() {
        UserImpl user =new UserImpl();
        user.setUserID(1);
        user.setUserName("海清");
        user.setAge(22);
        user.setAdminCode("1015320765");
        user.setPassword(MD5Utils.getSaltMD5("1456987"));
        user.setTelephone("17688432366");
        user.setEmailaccount("1015320765@qq.com");
        user.setCreatTime(System.currentTimeMillis());
        user.setImage("123654");
        userDao.updateUser(user);
        userDao.goodShowService();

    }

}