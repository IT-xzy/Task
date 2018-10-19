package cn.wyq.util;

import cn.wyq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class rmiClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService studentService = applicationContext.getBean("rmiStudentClient",StudentService.class);

        studentService.deleteStudent(147);
    }

}
