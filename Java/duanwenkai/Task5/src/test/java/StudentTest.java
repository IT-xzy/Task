import com.fml.pojo.Student;
import com.fml.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class StudentTest {
    @Autowired
    StudentService studentService;

    @Test
    public void TestStudentAdd(){
        Student student = new Student();

        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setStu_name("张小凡");
        student.setEmail("111222333@qq.com");
        student.setPassword("111222333");
        student.setLesson_type(11);
        student.setStu_status(3);
        student.setCompany("");
        student.setPost("");
        student.setDescription("好好学习，天天向上");
        for (int i = 0; i < 20; i++){
            studentService.add(student);
        }
    }
}
