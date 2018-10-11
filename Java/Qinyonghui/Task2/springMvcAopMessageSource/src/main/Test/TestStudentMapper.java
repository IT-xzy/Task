import com.jnshu.controller.StudentController;
import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStudentMapper {
    Logger logger = LogManager.getLogger(TestStudentMapper.class.getName());
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void findAllTest(){
        List studentList = studentMapper.findAll();
        logger.info(studentList);
    }
    @Test
    public void findOneByIdTest() {
        Student student = studentMapper.findOneById(12l);
        logger.info(student);
    }
    @Test
    public void deleteByIdTest() {
        boolean flag = studentMapper.deleteById(12);
        logger.info(flag);
    }
}
