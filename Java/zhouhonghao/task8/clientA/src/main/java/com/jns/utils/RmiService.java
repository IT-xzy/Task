package com.jns.utils;

import com.jns.service.StudentService;
import com.jns.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiService {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public StudentService getStudentService() {
        int rand=Math.random()>=0.5?1:0;
        if(rand==1){
            System.out.println("139.199.126.254的studentService");
        return (StudentService) context.getBean("studentService");
        }else{
            System.out.println("139.199.127.53的usersService");
            return (StudentService) context.getBean("studentService1");
        }
    }
    public UsersService getUsersService() {
        int rand=Math.random()>=0.5?1:0;
        if(rand==1){
            System.out.println("139.199.126.254的usersService");
        return (UsersService) context.getBean("usersService");
        }else{
            System.out.println("139.199.127.53的usersService");
            return (UsersService) context.getBean("usersService1");
        }
    }
}
