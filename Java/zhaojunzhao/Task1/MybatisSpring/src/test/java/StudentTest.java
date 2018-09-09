import com.mutesaid.pojo.Student;
import com.mutesaid.serviceImpl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class StudentTest {
    private Logger logger = LogManager.getLogger(StudentTest.class);

    @Autowired
    @Qualifier("studentService")
    private StudentServiceImpl studentService;

    @Autowired
    @Qualifier("student1")
    private Student student;

    @Before
    public void setUp() {
        logger.info("开始一项测试");
    }

    @After
    public void tearDown() {
        logger.info("结束一项测试");
    }

    @Test
    public void insert() {
        try{
            Long id = studentService.insert(student);
            logger.info("插入学生的id为{}",id);
        }catch (Exception e) {
            logger.info("插入失败{}.",e);
        }
    }

    @Test
    public void getById() {
        try{
            List<Student> stuList = studentService.getStudent("id",2);
            for(int i = 0;i < stuList.size();i++){
                logger.info("id为2的学生的信息为{}",stuList.get(i).toString());
            }
        }catch (Exception e) {
            logger.info("查找失败.",e);
        }
    }

    @Test
    public void getByName() {
        try{
            List<Student> stuList = studentService.getStudent("name","张新");
            for(int i = 0; i < stuList.size(); i++) {
                logger.info("姓名为张新的学生的信息为{}",stuList.get(i).toString());
            }
        }catch (Exception e) {
            logger.info("查找失败{}",e);
        }
    }

    @Test
    public void getByOnlineId() {
        try{
            List<Student> stuList = studentService.getStudent("online_id","6785");
            for(int i = 0; i < stuList.size(); i++) {
                logger.info("学号为6785的学生的信息为{}",stuList.get(i).toString());
            }
        }catch (Exception e) {
            logger.info("查找失败",e);
        }
    }

    @Test
    public void delete() {
        logger.info("开始删除Android-591");
        logger.info(studentService.delete("Android-591"));
    }

    @Test
    public void update() {
        logger.info("把学号为6785的学生的qq更新为999999999");
        logger.info(studentService.update("6785","qq",
                999999999,System.currentTimeMillis()));
    }

    @Test
    public void poolTest() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++) {
            studentService.insert(student);
        }
        long endTime = System.currentTimeMillis();
        logger.info("运行时间：{}",endTime - startTime);
    }
}
