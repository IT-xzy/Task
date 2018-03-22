import com.mapper.StudentMapper;
import com.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class timeTest {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    Student student;

    @Test
    public void hehe(){
       Student student = new Student();
       student = studentMapper.selectByPrimaryKey(1);
       System.out.println(student);
       System.out.println("时间"+student.getCreateTime());
        }

    }
