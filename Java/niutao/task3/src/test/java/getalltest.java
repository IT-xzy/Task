import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.GetAll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class getalltest {

    @Autowired
    private StudentMapper  studentMapper;

    @Test
    public void gogogo() throws Exception {
        GetAll gs = new GetAll();
        gs.setStudentMapper(studentMapper);
        List<Student> liststudent=  gs.doSomeBusinessStuff();
        System.out.println(liststudent);
    }
}