package demo.service;

import com.xiaobo.demo.entity.User;
import com.xiaobo.demo.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-servlet.xml")
public class UserServiceTest {
    private static Logger log = Logger.getLogger(UserServiceTest.class);
    @Autowired
    private UserService userService;
    @Test
    public void testGetAll(){
        List<User> result = userService.getAll();
        log.info(result);
        System.out.println(result.size());
    }
    @Test
    public void testGetUserById(){
        Integer id = 10;
        User result = userService.getUserById(id);
        log.info(result);
        System.out.println(result.getId());
    }
    @Test
    public void testDeleteUser() throws Exception{
        Integer id = 28;
        Boolean result = userService.deleteUser(id);
        log.info(result);
    }
    @Test
    public void testBatchDeleteUser() throws Exception{
        Integer id = 28;
        Boolean result = userService.deleteUser(id);
        log.info(result);
    }
    @Test
    public void testAddUser() throws Exception{

        User user = new User();
        user.setName("王婆");
        user.setSex("2");
        user.setPhone("18578785689");
        Integer result = userService.addUser(user);
        log.info(result);
        log.info(user.getId());
    }
    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setId(34);
        user.setName("李八");
        user.setSex("2");
        user.setPhone("18578895689");
        Boolean result = userService.updateUser(user);
        log.info(result);
    }
}
