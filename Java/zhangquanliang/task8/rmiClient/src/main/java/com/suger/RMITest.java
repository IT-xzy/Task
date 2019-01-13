package com.suger;

import com.suger.pojo.Student;
import com.suger.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author suger
 * @date 2019/1/3 23:29
 */
public class RMITest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

        StudentService studentService = applicationContext.getBean(StudentService.class);
        System.out.println("studentService = " + studentService);
        List<Student> students = studentService.findAll();
        System.out.println("students = " + students);
    }
}
