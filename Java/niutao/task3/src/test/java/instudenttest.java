import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetStudent;
import com.service.InStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class instudenttest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void gogogo() throws Exception {
        for(int i=0;i<5;i++) {
            int x=1+(int)(Math.random()*50);
            Student student = new Student();
            student.setName("呵呵"+x);
            student.setQq("304584817");
            student.setClass_id(1);
            student.setGraduate_school("家里蹲");
            student.setOline_number("java-445");
            student.setLink("www.baidu.com");
            student.setWish("没有");
            student.setBrother_id(1);
            System.out.println(student);
            InStudent inStudent = new InStudent();
            inStudent.setStudentMapper(studentMapper);
            inStudent.doSomeBusinessStuff(student);
        }
    }
}
