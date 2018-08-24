
import com.lihoo.ssm.gai.service.UserService;
import com.lihoo.ssm.gai.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lihoo
 * @Title: UserTest
 * @ProjectName spring_mybatis_1
 * @Description: TODO
 * @date 2018/8/2-18:41
 */

public class UserTest {

//    @Autowired
//    UserService userService;

    private ApplicationContext applicationContext;

    // 在执行测试方法之前首先获取 Spring 配置文件对象
    // 注解@Before在执行本类所有测试方法之前先调用这个方法
    @Before
    public void setup() throws Exception {
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }









    @Test
    public void testFindUserList() throws Exception {
        //
        UserService userService = (UserService) applicationContext.getBean("userService");
        //
        List<User> list = userService.findUserList();
        //
        for (User userList : list) {
            System.out.println(userList);
        }

    }


    @Test
    public void testFindUserByName() throws Exception {

        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = userService.findUserByName("艾福杰尼");

        System.out.println(user.getId() + ":" +user.getUsername());

    }


    @Test
    public void testFindUserById() throws Exception {
        //  通过配置资源对象获取 userDAO 对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        // 调用 UserDAO 的方法
        User user = userService.findUserById(2);
        //输出用户信息
        System.out.println(user.getId() + ":" + user.getUsername() + "," +user.getQq());
    }






    @Test
    public void testAddUser() throws Exception {
        //  通过配置资源对象获取 userDAO 对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        // 调用 UserDAO 的方法
        User user = new User();
//        user.setId(4);
        user.setUsername("吴亦凡");
        user.setQq(753951);
        user.setSchool("SB");
        user.setJob("rapper");
        user.setUrl("www.tokyohot.com");

        int us = userService.addUser(user);

        System.out.println(us);
        System.out.println(user.getId() + ":" + user.getUsername() );

    }

    @Test
    public void testDeleteUser() throws Exception {
        UserService userService = (UserService) applicationContext.getBean("userService");

        int user = userService.deleteUser(14);

        System.out.println(user);

    }

    @Test
    public void testUpdateUser() throws Exception {
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = new User();
        user.setId(9);
        user.setUsername("黄旭");

        userService.updateUser(user);

        System.out.println(user.getId() + ":" + user.getUsername() );
    }




}

//    @Test
//    public void testFindUserList() throws Exception {
//
//        UserService userDao = (UserService) applicationContext.getBean("userDao");
//        List<User> list = userDao.findUserList();
//
//        for (User user : list) {
//            System.out.println(user);
//        }
//
//
//        System.out.println(list.size());
//    }
