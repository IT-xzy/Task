package com.student.mapping;

import com.student.model.User;
import com.student.service.UserService;
import com.student.tools.TimeTransition;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDaoTest {

    private static ApplicationContext applicationContext;
    private static UserService userService;
    static {
//        创建spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        userService = ctx.getBean(UserService.class);
    }

    @Test
    public void getAllUser() {
        System.out.println("====================所有信息====================");
        try {
            userService.forlist(userService.getAllUser());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id:getAllUser 执行失败");
        }

    }

    @Test
    public void getUserMore() {
        User user3 = new User();
        User user6 = new User();
         user3.setName("马苏德");
         user6.setOnline_id(3933);
            System.out.println("====================指定信息====================");
        try {
            userService.forlist(userService.getUserMore(user3));
            userService.forlist(userService.getUserMore(user6));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-name:getUserMore 执行失败");
        }
    }


    @Test
    public void addUser() {
        User user1 = new User();
        user1.setCreate_at();
        user1.setName("萨尔瓦多");
        user1.setDaily_link("www.willing.com");
        user1.setEntrance_time(TimeTransition.dateToLong(new Date()));
        user1.setLearning_type("QA测试工程师");
        user1.setOnline_id(5868);
        user1.setSchool("上海大学");
        user1.setQq("5201314");
        user1.setTutor("名山");
        user1.setWish("好好学习，天天向上");
        try {
            userService.addUser(user1);
            System.out.println("插入数据位于id：" + user1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteUser() {
        try {
            System.out.println("删除状态:" + userService.deleteUser(26));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        User user2 = new User();
        user2.setId(7);
        user2.setCreate_at();
        user2.setName("Tony");
        user2.setDaily_link("www.willing.com");
        user2.setEntrance_time(TimeTransition.dateToLong(new Date()));
        user2.setLearning_type("QA测试工程师");
        user2.setOnline_id(5858);
        user2.setSchool("中山大学");
        user2.setQq("5201314");
        user2.setTutor("名山");
        user2.setWish("好好学习，天天向上");
        try {
            System.out.println("更新状态：" + userService.updateUser(user2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}