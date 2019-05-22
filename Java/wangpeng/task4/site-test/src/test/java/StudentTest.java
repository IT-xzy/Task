import cn.wp.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/20 16:43
 * @Version: 1.0
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {
    @Autowired
    StudentService studentService;
    Logger logger = Logger.getLogger(StudentTest.class);

    @Test
    public void selectAll() {
        logger.info(studentService.selectAll());
    }

    @Test
    public void selectBySalary() {
        logger.info(studentService.selectBySalary());
    }
}
