package lujing.serviceimpl;

import lujing.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author lujing
 * Create_at 2018/1/5 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})
public class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;
    
    @Test
    public void findUser() {
        User userxx = new User();
        User user1 = new User();
        
        user1.setName("admin");
        user1.setPassword("admin");
        
        userxx.setName("admin");
        userxx.setPassword(null);
    }
    
    @Test
    public void findUserByName() {
        System.out.println( userServiceImpl.findUserByName("admin"));
    }
    
    @Test
    public void siginUser() {
        User testuser = new User();
        testuser.setName("admin");
        testuser.setPassword("admin");
        System.out.println(userServiceImpl.siginUser(testuser,""));
    }
}
