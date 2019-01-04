package com.suger.service.impl;

import com.suger.pojo.Student;
import com.suger.pojo.User;
import com.suger.service.StudentService;
import com.suger.service.UserService;
import com.suger.util.DataUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author suger
 * @date 2018/12/22 21:52
 */
public class UserServiceImplTest {
    ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
    UserService userService = context.getBean(UserService.class);
    StudentService studentService = context.getBean(StudentService.class);
    @Test
    public void insertUser() throws Exception {
        /*User user = new User();
        user.setName("zql");
        Long id = userService.insertUser(user);
        System.out.println("id = " + id);
        userService.findAll();
        int studyNum = studentService.getStudentByType(false).size();
        System.out.println("studyNum = " + studyNum);*/

        String msgCode = DataUtils.getNumber(6);

       /* int i= userService.sendPhone("15637921325",msgCode);
        System.out.println("i = " + i);
        int j = userService.checkPhoneCode("15637921325",msgCode);
        System.out.println("j = " + j);*/
       /*int i = userService.sendEmai("suger_z@126.com",msgCode);
        System.out.println("i = " + i);
        int  j = userService.checkEmailCode("suger_z@126.com",msgCode);
        System.out.println("j = " + j);*/
      /* User user =userService.getUserByName("zql");
        System.out.println("user = " + user);*/
    }

}