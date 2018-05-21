import com.DAO.StudentMapper;
import com.POJO.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/StudentBeans.xml")
public class StudentTest {
    @Autowired
    private StudentMapper studentMapper;
    
    @Test
    public void findUserById() throws Exception {
        
        Student student = studentMapper.findUserById(1);
        System.out.println(student);
        
    }
}
