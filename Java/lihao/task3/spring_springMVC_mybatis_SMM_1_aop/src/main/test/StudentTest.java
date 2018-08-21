
import com.lihoo.ssm.gai.dao.StudentDao;
import com.lihoo.ssm.gai.service.StudentService;
import com.lihoo.ssm.gai.model.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lihoo
 * @Title: StudentTest
 * @ProjectName spring_mybatis_1
 * @Description: 测试类
 * @date 2018/8/3-20:25
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
public class StudentTest {

    //**打印日志**//
    private static Logger logger = Logger.getLogger(StudentTest.class);
//    private static Logger logger = LogManager.getLogger("DebugLogger");

    @Autowired
    StudentDao studentDao;

    @Test
    public void testFindStudentList() throws Exception {
        logger.debug("开始查询学员");
        List<Student> list = studentDao.findStudentList();
        for (Student studentList:  list) {
            logger.debug(studentList);
        }
        logger.debug("查询成功！！！");
    }

    
    @Test
    public void testFindStudentById() throws Exception {
        logger.debug("开始查询学员");
        Student stu_id = studentDao.findStudentById(15);
        logger.debug(stu_id);
        logger.debug("查询成功！！！");
    }

    @Test
    public void testFindStudentByName() throws Exception {
        logger.debug("开始查询学员");
        Student student_name = studentDao.findStudentByName("杨纲");
        logger.debug("学员：" + student_name);
        logger.debug("查询成功！！！");
    }

    @Test
    public void testAddStudent() throws Exception {
        logger.debug("开始添加学员");
        Student stu = new Student();
        stu.setUsername("温思默克@山治");
        stu.setQq_num(9999);
        stu.setStudy_type("pm");
        stu.setStudy_time(1533348646);
        stu.setSchool("黑科技");
        stu.setStudy_id("pm-75486");
        stu.setDaily_link("onepice.com");
        stu.setPromise("皮一下");
        stu.setTeach_bro("大将黄狗");
        stu.setKnow_us_from("nice大夫");
        stu.setCreate_at(1533366950);
        stu.setUpdate_at(1533374875);
        studentDao.addStudent(stu);
        logger.debug("添加学员:" +stu);
        logger.debug("添加学员成功！！！");
    }

    @Test
    public void testDeleteStudent() throws Exception {
        logger.debug("开始删除学员");
        Student stu_del = new Student();
        stu_del.setId(26);
        studentDao.deleteStudent(stu_del);
        logger.debug("删除成功");
    }

    @Test
    public void testUpdateStudent() throws Exception {
        logger.debug("开始更改学员");
        Student stu = new Student();
        stu.setId(2);
        stu.setUsername("玛里苟斯111");
        stu.setSchool("新泽西大学");
        stu.setDaily_link("www.nice——daifu.com");
        stu.setUpdate_at(1534268749);
        studentDao.updateStudent(stu);
        logger.debug("更改学员信息成功");
    }
}
