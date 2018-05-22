import com.longhang.stuDao.StudentDao;
import com.longhang.stuModel.Student;
import com.longhang.stuService.StuService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration("classpath:applicationContext.xml")

public class Tests {
    private static Logger logger = Logger.getLogger(Tests.class);
    @Autowired
    private StuService stu;
    private StudentDao s;

    @Test
    public void test1() {
        Student student = stu.getStuById(555L);

        logger.info(student);
//        System.out.println(student);
    }
    @Test
    public void getAll() {
        List<Student> students = s.getAll();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            logger.info("" + it.next());
        }
    }
}