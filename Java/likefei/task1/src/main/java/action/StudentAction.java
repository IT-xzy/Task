package action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import pojo.Student;
import service.StudentService;

@Controller
public class StudentAction {
    @Autowired
    private StudentService studentService;

    public StudentAction() {
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentAction studentAction = (StudentAction)context.getBean("studentAction");
        Student student = new Student();
        student.setName("李");
        student.setAge(10);
        List<String> list = new ArrayList();

        for(int i = 0; i < 150000; ++i) {
            list.add(student.getName());
        }

        System.out.println(studentAction.studentService.add(student));
        System.out.println(studentAction.studentService.delete(4943001));
        System.out.println(studentAction.studentService.get(5));
        System.out.println(studentAction.studentService.update(student));
        System.out.println(studentAction.studentService.pinsert(list));
    }
}
