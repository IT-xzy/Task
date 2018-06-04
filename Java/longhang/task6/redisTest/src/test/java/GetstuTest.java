import com.longhang.model.Student;
import com.longhang.stuService.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GetstuTest {
    @Autowired
    private StuService stu;
    @Test
    public void getTest(){

//        List<Student> ss=stu.getGetAll();
        Student s=stu.getStuById(28L);
        System.out.println(s);
        //System.out.println("这个学生是："+s.toString());
    }
}
