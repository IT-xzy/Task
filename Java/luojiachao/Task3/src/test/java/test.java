import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task2.mapper.StudentMapper;
import task2.pojo.Student;
import task2.service.StudentService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class test {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentService studentService;

    @Test
    public void list() {
        List<Student> user= studentMapper.list();
        System.out.println(user);
    }
}

