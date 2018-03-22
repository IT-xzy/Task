
import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class getstudenttest {

    @Autowired
    private StudentMapper  studentMapper;

    @Test
    public void gogogo() throws Exception {
        GetStudent gs = new GetStudent();
        gs.setStudentMapper(studentMapper);
        Student student =  gs.doSomeBusinessStuff(1);
        System.out.println(student);
    }
}