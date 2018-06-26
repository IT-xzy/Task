package com.student.main;

import com.student.model.User;
import com.student.service.UserService;
import com.student.tools.TimeTransition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Client {
    private static ApplicationContext applicationContext;
    private static UserService userService;
    static {
//        创建spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        userService = ctx.getBean(UserService.class);
    }


    public static void main(String[] args) throws Exception {

//       查询所有信息
        try {
            System.out.println("====================所有信息====================");
        userService.forlist(userService.getAllUser());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("sql-id:getAllUser 执行失败");
        }

//        根据查询条件获取信息
        User user3 = new User();
        user3.setName("马苏德");
        try {
            System.out.println("====================指定信息====================");
            userService.forlist(userService.getUserMore(user3));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql-name:getUserMore 执行失败");
        }
//        插入数据

        User user1 = new User();
        user1.setCreate_at();
        user1.setName("周天");
        user1.setDaily_link("www.willing.com");
        user1.setEntrance_time(TimeTransition.dateToLong(new Date()));
        user1.setLearning_type("QA测试工程师");
        user1.setOnline_id(5858);
        user1.setSchool("上海大学");
        user1.setQq("5201314");
        user1.setTutor("名山");
        user1.setWish("好好学习，天天向上");
        try {
            System.out.println("插入状态："+userService.addUser(user1));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        删除数据
        try {
            System.out.println("删除状态:" + userService.deleteUser(26));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        更新数据
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
            System.out.println("更新状态："+ userService.updateUser(user2));
        } catch (Exception e) {
            e.printStackTrace();
        }

/*//        for循环调用函数
        for (int i=0;i < 1000;i++){
            System.out.println("循环次数："+ i);
            User user4 = new User();
            user4.setLearning_type("后端工程师");
            try {
                userService.forlist(userService.getUserMore(user4));
                System.out.println("查询成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("查询失败");
                throw e;
            }
        }*/
    }
}
