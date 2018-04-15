package com;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.StudentJDBCTemplate;
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        System.out.println("Records Creation");
        studentJDBCTemplate.create("韩",12);
//        List<Student> students = studentJDBCTemplate.listStudents();
//        for (Student record:students) {
//            System.out.println("ID:" + record.getId());
//            System.out.println(", Name : " + record.getName());
//        }
        System.out.println("update start");
        studentJDBCTemplate.update(12,"韩大师");
//        studentJDBCTemplate.delete(12);
    }
}
