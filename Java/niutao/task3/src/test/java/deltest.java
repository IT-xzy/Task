import com.mapper.StudentMapper;
import com.service.DelStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class deltest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void gogogo() throws Exception {
        DelStudent delstudent = new DelStudent();
        delstudent.setStudentMapper(studentMapper);
        delstudent.doSomeBusinessStuff(26);
    }
}
