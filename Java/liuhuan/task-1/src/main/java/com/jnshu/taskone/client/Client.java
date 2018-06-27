package com.jnshu.taskone.client;

import com.jnshu.taskone.model.User;
import com.jnshu.taskone.service.UserService;
import com.jnshu.taskone.serviceImpl.UserServiceImpl;
import com.jnshu.taskone.tools.TimeTransition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Client {
    private static ApplicationContext applicationContext;
    private static UserService userService;
    static {
        /* 创建Spring容器 */
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        /* 从spring容器中获取UserDao这个bean */
        userService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
    }

    public static void main(String[] args) {

        /*  查看所有用户 */
        try {
            userService.forlist(userService.findUserAll());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id: findUserAll 执行失败 ");
        }
        /*  根据信息查找 */
        User user = new User();
        user.setProfession("java");
        try {
            userService.forlist(userService.findUserMore(user));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id: findUserMore 执行失败 ");
        }

        /*  插入 */
        User user1 = new User();
        user1.setUsername("王五");
        user1.setQq("1756513254");
        user1.setProfession("UI");
        user1.setJoin_date(TimeTransition.dateTolong(new Date()));
        user1.setSchool("武汉大学");
        user1.setOnline_id("3879");
        user1.setDaily_url("www.google.com");
        user1.setCounselor("加油");
        user1.setCreate_time();
        try {
            System.out.println("插入状态为: " + userService.insertUser(user1));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id: insertUser 执行失败 ");
        }

        /*  删除 */
        try {
            System.out.println("删除状态为: " + userService.deleteUser(55));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id: deleteUser 执行失败 ");
        }

        /*  更新 */
        User user2 = new User();
        user2.setUsername("111");
        user2.setQq("1756513254");
        user2.setProfession("UI");
        user2.setJoin_date(TimeTransition.dateTolong(new Date()));
        user2.setId(33);
        try {
            System.out.println("更新状态为: " + userService.updateUser(user2));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-id: updateUser 执行失败 ");
        }
    }
}
