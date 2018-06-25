import com.longhang.stuService.StuService;
import com.longhang.util.SelectUtli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

public class MyTest {
    StuService stu=SelectUtli.getStudentService();
    @Test
            public void ss() {
        System.out.println( stu.getGetAll());
    }
}
