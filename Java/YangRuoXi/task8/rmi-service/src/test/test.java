import com.jnshu.rmi.beans.Student;
import com.jnshu.rmi.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class test {

    @Autowired
    StudentService studentService;

    @Test
    public void test(){
        List<Student> students = studentService.findAllStu();
        System.out.println(students);

        Student student = studentService.findStuById((long) 1);
        System.out.println(student);


    }
}
