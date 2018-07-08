package com.task.util;


import com.task.service.HelloService;
import com.task.service.StudentService;
import com.task.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryUtil {

    private HelloService helloService;
    private UserService userService;
    private StudentService studentService;

    private static ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-context.xml");


    public HelloService getHelloService() {

        int a= (int) ((Math.random()*999999)%2);
        if (a==0){
            HelloService helloService= (HelloService) ctx.getBean("hello1");
            System.out.println("s1");
            return helloService;
        }
        else {
            HelloService helloService= (HelloService) ctx.getBean("hello2");
            System.out.println("s2");
            return helloService;
        }
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public UserService getUserService() {

        int a= (int) ((Math.random()*999999)%2);
        if (a==0){
            UserService userService= (UserService) ctx.getBean("user1");
            System.out.println("s1");
            return userService;
        }
        else {
            UserService userService= (UserService) ctx.getBean("user2");
            System.out.println("s2");
            return userService;
        }

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public StudentService getStudentService() {

        int a= (int) ((Math.random()*999999)%2);
        if (a==0){
            StudentService studentService= (StudentService) ctx.getBean("student1");
            System.out.println("s1");
            return studentService;
        }
        else {
            StudentService studentService= (StudentService) ctx.getBean("student2");
            System.out.println("s2");
            return studentService;
        }
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
