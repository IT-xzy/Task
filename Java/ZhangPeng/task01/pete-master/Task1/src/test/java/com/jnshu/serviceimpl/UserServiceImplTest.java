package com.jnshu.serviceimpl;

import com.jnshu.dao.UserDao;
import com.jnshu.model.User;
import com.jnshu.service.impl.UserService;
import com.jnshu.service.impl.UserServiceImpl;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

public class UserServiceImplTest {
    private static ApplicationContext applicationContext;
    private static UserService userService;

    @Before
    public void tests(){
        //创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        userService =(UserServiceImpl) applicationContext.getBean("userServiceImpl");

    }
@Test
    public void insertUser() {

    User user = new User();
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            user.setName("张三");
            user.setQq("1111");
            user.setType("java");
            user.setEntranceTime(new Date(System.currentTimeMillis()));
            user.setSchool("北大");
            user.setOnlineNum(111);
            user.setWish("");
            user.setDailyLink("");
            user.setBrother("");
            user.setWhereKnown("");
            user.setCreate_at(new Date(System.currentTimeMillis()));
            user.setUpdate_at(new Date(System.currentTimeMillis()));
            try {
                System.out.println("插入id" + userService.insertUser(user));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
    @Test
    public void findUserAll() {

        try{
            List<User> list = userService.findUserAll();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }
    @Test
    public void updateUser(){
 User user = new User();
 user.setName("李四");
 user.setQq("222");
 user.setBrother("王五");
 user.setWish("老大最帅");
 user.setEntranceTime(new Date(System.currentTimeMillis()));
 user.setId(01);
 try{
     System.out.println(("更新状态为"+userService.updateUser(user)));
 }catch (Exception e){
     e.printStackTrace();
 }
    }
   @Test
    public void deleteUser(){
       try{
           System.out.println("删除成功"+userService.deleteUser(4));
       }catch(Exception e){
           e.printStackTrace();
       }


    }

@Test
    public void findUserById() throws Exception {

        try{
            System.out.println("查询成功"+userService.findUserById(20));
        }catch (Exception e){
            e.printStackTrace();
        }
}
@Test
public void findUserByCondition()throws Exception {

    try {

        List<User> list = userService.findUserByCondition("张");
        for (int i = 0; i < 10; i++)
            System.out.println("打印成功"+list.get(i));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
