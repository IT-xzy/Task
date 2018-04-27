import com.Student;
import com.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class MainApp {
    @Autowired
    static StudentMapper studentMapper;
    public static void main(String[] args) throws Exception {
        Student student = studentMapper.findUserById(1);
        System.out.println(student);
    }
}
