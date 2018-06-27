package com.jnshu.client;

import com.jnshu.model.User;
import com.jnshu.service.impl.UserService;
import com.jnshu.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Client {
    private static ApplicationContext applicationContext;
   private static UserService userService;

   static {
       //创建spring容器
     applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
       //读取bean对象
      userService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
    }

  public static void main(String[] args) {
    //  查看所有用户

    try {
       userService.forList(userService.findUserAll());
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("sql-id: findUserAll 执行失败 ");
    }

//查询ID
       User user = new User();
      user.setId(20);
      try {
          user = userService.findUserById(20);
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("sql-id: findUserById 执行失败 ");
     }
      //增加数据
       User user1 = new User();
      user1.setName("王五");
      user1.setQq("1111");
      user1.setType("java");
      user1.setEntranceTime(new Date(System.currentTimeMillis()));
      user1.setSchool("五大");
      user1.setOnlineNum(222);
      user1.setWish("老大帅");
      user1.setDailyLink("111222");
      user1.setBrother("333");
      user1.setWhereKnown("4444");
      user1.setCreate_at(new Date(System.currentTimeMillis()));
      user1.setUpdate_at(new Date(System.currentTimeMillis()));
       try {
           userService.insertUser(user1);
       } catch (Exception e) {
          e.printStackTrace();
         System.out.println("sql-id: insertUser 执行失败 ");
      }
        //修改数据
       User user2 = new User();
        user.setName("王五");
        user.setQq("333");
      user.setType("PM");
       user.setEntranceTime(new Date(System.currentTimeMillis()));
       user.setSchool("武大");
       user.setOnlineNum(333);
       user.setWish("老大最不帅");
      user.setDailyLink("2222");
      user.setId(10);
       try{
           userService.updateUser(user2);
        }catch (Exception e){
          e.printStackTrace();
          System.out.println("sql-id:updateUser 执行失败 ");
       }
//删除数据
try {
          System.out.println("删除成功"+userService.deleteUser(8));
  }catch(Exception e){
           e.printStackTrace();
    System.out.println("sql-id:deleteUser 执行失败 ");
  }
       }


  }
