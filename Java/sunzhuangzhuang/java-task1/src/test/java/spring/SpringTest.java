package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.demo.User;
import spring.service.UserService;
import java.util.List;

public class SpringTest {

    @Test
    public void testUserDao(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        User user = new User();
        user.setName("tom");
        user.setAge(21);
        user.setCreatedate(System.currentTimeMillis());
        user.setUp(System.currentTimeMillis());
        System.out.println("插入的ID为："+userService.add(user));
    }
        @Test
        public void testDelete() {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService = applicationContext.getBean(UserService.class);
            userService.delete(11);
            System.out.println("删除成功！");
        }catch (Exception e){
            System.out.println("删除失败！");
        }
    }
        @Test
        public void testUpdate() {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService = applicationContext.getBean(UserService.class);
            User user = new User();
            user.setName("小黄");
            user.setAge(26);
            user.setUp(System.currentTimeMillis());
            user.setId(12);
            userService.update(user);
            System.out.println("更新成功！");
        }catch (Exception e){
            System.out.println("更新失败！");
        }

    }
        @Test
        public void testSelect(){
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService = applicationContext.getBean(UserService.class);
            User user = new User();
            user.setId(12);
            List<User> users = userService.select(user);
            for (User user1:users) {
                System.out.println(user1);
            }
        }
        @Test
        public void testQuery(){
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService = applicationContext.getBean(UserService.class);
            List<User> list = userService.query();
            for (User user:list) {
                System.out.println(user);
            }
        }
    }

