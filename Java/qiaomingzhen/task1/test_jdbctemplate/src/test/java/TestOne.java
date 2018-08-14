import com.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 17:11$
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOne {
    //    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//    UserService userService = (UserService) ctx.getBean("userService");
//    User user = (User) ctx.getBean("user");
    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    //增加用户，返回id
    @Test
    public void testAddUser() {
        user.setName("乔");
        user.setQq(1111111);
        user.setType("java");
        long id = userService.addUser(user);
        System.out.println("返回id" + id);
    }

    //根据名字删除用户
    @Test
    public void textDeleteUser() {
        user.setName("乔");
        boolean b = userService.deleteUser(user);
        System.out.println("删除用户=====" + b);
    }

    //更新用户
    @Test
    public void testUpdateUser() {
        user.setType("web");
        user.setName("乔");
        userService.updateUser(user);
        boolean b = userService.deleteUser(user);
        System.out.println("更新用户====="+b);
    }

    //根据名字查询用户修真类型
    @Test
    public void testSelectUser() {
        user.setName("程荣强");
        User user1=userService.selectUser(user);
        System.out.println(user.getName()+"的修真类型==="+user1.getType());
    }
}

