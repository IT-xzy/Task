package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.demo.User;
import spring.service.UserService;

import java.util.List;

public class Test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        //添加数据
        User user = new User();
        user.setName("tom");
        user.setAge(21);
        user.setCreatedate(System.currentTimeMillis());
        user.setUp(System.currentTimeMillis());
        System.out.println("插入的ID为："+userService.add(user));

        //删除数据
        try {
            userService.delete(13);
            System.out.println("删除成功！");
        }catch (Exception e){
            System.out.println("删除失败！");
        }

        //更改数据
        try {
            User user1 = new User();
            user.setName("小黄");
            user.setAge(26);
            user.setUp(System.currentTimeMillis());
            user.setId(12);
            userService.update(user);
            System.out.println("更新成功！");
        }catch (Exception e){
            System.out.println("更新失败！");
        }
        //根据ID或者名字或者年龄来查询
        User user2 = new User();
        user.setId(13);
        List<User> users = userService.select(user);
        for (User user1:users) {
            System.out.println(user1);
        }

        //查询所有数据
        List<User> list = userService.query();
        for (User user3:list) {
            System.out.println(user);
        }
    }

}
