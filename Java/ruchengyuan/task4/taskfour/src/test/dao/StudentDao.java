package dao;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.dao.StudentMapper;
import task.jnshu.model.Student;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 6/8/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class StudentDao {

    private static Logger loggerStudyTest = Logger.getLogger(StudentDao.class);

    @Resource
    private StudentMapper studentMapper;
    //作用：StudentMapper studentMapper = (StudentMapper) ctx.getBean("mapper");

    @BeforeClass
    public static void begin(){
        loggerStudyTest.info("测试开始");
    }

    @AfterClass
    public static void end(){
        loggerStudyTest.info("测试结束");
    }


    @Test
    public void studentSelect(){
        try {
            loggerStudyTest.info("测试查询\n");
//            StudentMapper studentMapper = (StudentMapper) ctx.getBean("mapper");
            Student study = new Student();
            study = studentMapper.selectByPrimaryKey(1);
            loggerStudyTest.info("学生信息： \n" + study);
        }catch (Exception e){
            e.printStackTrace();
            loggerStudyTest.error("查询失败 " + e.getMessage());
        }
    }

    @Test
    public void insert(){
        try {
            loggerStudyTest.info("添加信息\n");
//            StudentMapper studentMapper = (StudentMapper) ctx.getBean("mapper");
            Student study = new Student();
            long enrolAt = System.currentTimeMillis();
            study.study(6,"qwe","123456","/statics/image/task10/242424.png","CSS",1,"爱贝多","男",12211,
                    1,enrolAt,enrolAt,enrolAt);
            int i  = studentMapper.insert(study);
            loggerStudyTest.info("学生信息： \n" + study);
            loggerStudyTest.info("返回影响行数： \n" + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerStudyTest.error("查询失败 " + e.getMessage());
        }
    }

    @Test
    public void delete(){
        try{
            loggerStudyTest.info("删除学员信息\n");
//            StudentMapper studentMapper = (StudentMapper) ctx.getBean("mapper");
            int i  = studentMapper.deleteByPrimaryKey(6);
            loggerStudyTest.info("返回影响行数： \n" + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerStudyTest.error("删除失败 " + e.getMessage());
        }
    }

    @Test
    public void studentAll(){
        try{
            List<Student> students = studentMapper.studentAll();
            loggerStudyTest.info("返回学生信息： \n" + students);

        }catch (Exception e){
            e.printStackTrace();
            loggerStudyTest.error("all失败 " + e.getMessage());
        }
    }
}
