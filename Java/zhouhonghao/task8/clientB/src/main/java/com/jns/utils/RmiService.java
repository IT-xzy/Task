package com.jns.utils;

import com.jns.service.StudentService;
import com.jns.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiService {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public StudentService getStudentService() {
        return (StudentService) context.getBean("studentService");
    }
    public UsersService getUsersService() {
        return (UsersService) context.getBean("usersService");
    }
}
