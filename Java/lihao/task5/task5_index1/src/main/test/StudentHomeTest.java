import com.lihoo.ssm.dao.StudentHomeMapper;
import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Title: StudentHomeTest
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-14:09
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class StudentHomeTest {

    private static Logger logger = LogManager.getLogger(StudentHomeTest.class);

    @Autowired
    StudentHomeMapper studentHomeMapper;

    @Test
    public void testAllStudents() {
        logger.info("查找所有学生");
        List<StudentHome> list = studentHomeMapper.selectAll();
        for (StudentHome allStus : list) {
            logger.info(allStus);
        }

        logger.info("查询结束");
    }

    @Test
    public void testFindById() {
        logger.info("通过ID查找");
        StudentHome stu = studentHomeMapper.selectByPrimaryKey(1L);
        logger.info(stu);
        logger.info("查询结束");

    }

    @Test
    public void testCountAll() {
        logger.info("开始查询");
        int list = studentHomeMapper.countAll();
        logger.info(list);
        logger.info("总人数为：" + list );
    }

    @Test
    public void testWorkingCounts() {
        logger.info("查询就业人数");
        int workList = studentHomeMapper.workingCount();
        logger.info(workList);
        logger.info("已经就业人数为：" + workList + "人");
    }

    @Test
    public void testGreatStudents() {
        logger.info("查询优秀学员");
        List<StudentHome> greatList = studentHomeMapper.selectGreatStudent();

//        String i = greatList.toString();
//        logger.info("mySOS:" + i );

        for (StudentHome list : greatList) {
            logger.info(list);
            logger.info(list.getHeadImg());
            logger.info(list.getUsername());
            logger.info(list.getUserInfo());
        }

//        logger.info(l);
        logger.info("查询成功");
    }


}
