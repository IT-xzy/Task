import com.lihoo.ssm.dao.StudentProfessionMapper;
import com.lihoo.ssm.model.StudentProfession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Title: ProfessionTest
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/29-14:57
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ProfessionTest {
    private static Logger logger = Logger.getLogger(ProfessionTest.class);

    @Autowired
    StudentProfessionMapper studentProfessionMapper;

    @Test
    public void testCountAll() {
        logger.debug("开始查询");
        int counts = studentProfessionMapper.countAll();

        logger.debug(counts+"条");

    }

    @Test
    public void testProfessionInfo() {
        logger.debug("开始查询");
        List<StudentProfession> listPro = studentProfessionMapper.selectAll();
        for (StudentProfession stuInfo : listPro) {
//            logger.debug("学生信息:"+ stuInfo);
            logger.debug("学生职业选择:"+ stuInfo.getJob());
            logger.debug("学生职业信息:"+ stuInfo.getJobInfo());
            logger.debug("一阶薪资:"+ stuInfo.getSalary1());
            logger.debug("二阶薪资:"+ stuInfo.getSalary2());
            logger.debug("三阶薪资:"+ stuInfo.getSalary3());
            logger.debug("浮动职业信息:"+ stuInfo.getHoverInfo());
            logger.debug("创建时间:"+ stuInfo.getCreateAt());
            logger.debug("修改时间:"+ stuInfo.getUpdateAt());
            logger.debug("**********************************");

        }
        logger.debug("结束查询");
    }

    @Test
    public void testJob() {
        logger.debug("开始查询");
        List<StudentProfession> jobList = studentProfessionMapper.findJob();

        for (StudentProfession list : jobList) {
            logger.debug("职业："+ list);
        }


        logger.debug("结束查询");
    }
}
