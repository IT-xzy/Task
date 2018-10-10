package server;

import com.jns.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class StudentServer {
    public static void main(String[] args) {
        //System.setProperty("java.rmi.server.hostname","139.199.127.53");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rmiServer.xml");
        StudentService studentService= (StudentService) applicationContext.getBean("studentService");
        System.out.println(studentService.total());
        System.out.println("UsersService ,发布成功！");
    }
}
