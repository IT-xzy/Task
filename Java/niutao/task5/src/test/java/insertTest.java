import com.mapper.StudentMapper;
import com.pojo.Student;
import com.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class insertTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void gogoinsert(){
        Student student = new Student();
        student.setUserName("newniutao1");
        student.setPassWord(MD5.getMD5("123"));
        Date day = new Date();
        student.setCreateTime(day);
        student.setUpdateTime(day);
        studentMapper.insert(student);
    }
}
