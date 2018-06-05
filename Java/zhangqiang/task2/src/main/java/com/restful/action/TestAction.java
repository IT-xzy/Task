package com.restful.action;

import com.restful.model.Student;
import com.restful.model.User;
import com.restful.service.RandomUser;
import com.restful.service.StudentServiceImpl;
import com.restful.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class TestAction {

    private Logger logger = Logger.getLogger(TestAction.class.getName());

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmybatis.xml");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");

    @Test
    public void test(){

        RandomUser randomUser = new RandomUser();
//        User user = randomUser.getRandomUser();
        Student student = new Student();
//        logger.info("插入数据id："+userService.insertOne(user));
//
//        logger.info("总数" + userService.findAllCount() + "条");
//
//        logger.info("修改前"+userService.findById(3).toString());
//
//        user = randomUser.getRandomUser();
//        user.setId(3);
//        logger.info("修改数据："+userService.updateOne(user) + "条");
//
//        logger.info("修改后"+userService.findById(3).toString());

//        logger.info("分页查询："+ userService.findByPage(2,3));
//        user = new User();
//        user.setName("汪洋");
//        logger.info(userService.findByUser(user).toString());
//        student.setName("226");
//        logger.info(studentService.findByStudent(student).toString());
//

        String name ="1";
        String pwd ="1";

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        logger.info("登录信息："+user.toString());

        List<User> users = userService.findByUser(user);

        for(User us : users){
            logger.info("查询匹配信息：" + us.toString());

            logger.info(String.valueOf(us.getName().equals(name)));
        }
    }




}
