package testdao;

import com.tasktwo.dao.StudentMapper;
import com.tasktwo.model.Student;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Ignore;

/**
 * Created by Administrator on 25/7/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class StudentTest {

    private static Logger loggerTest = Logger.getLogger(Test.class);

    @Autowired
    ApplicationContext ctx;

    @BeforeClass
    public static void begin(){
        loggerTest.info("测试开始");
    }

    @AfterClass
    public static void end(){
        loggerTest.info("测试结束");
    }


    @Test
    public void studentSelect(){
        try {
            loggerTest.info("测试查询\n");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            Student student = new Student();
            student = studentMapper.studySelect("CSS-1111");
            loggerTest.info("学生信息： \n" + student);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("查询失败 " + e.getMessage());
        }
    }

    @Test
    public void studentInsert(){
        try {
            loggerTest.info("测试添加");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            Student student1 = new Student();
            long entry_data = System.currentTimeMillis();
            student1.Student("CS-1233", "王尼玛 ", 1, 112233, entry_data,"郑州大学",
                    "www.baidu.com","","知乎",entry_data,entry_data);

            studentMapper.studyInsert(student1);
            loggerTest.error(student1);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("添加错误" + e.getMessage());
        }
    }


    @Test
    public void studentUpdate(){
        try {
            loggerTest.info("测试修改");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            Student student4 = new Student();
            student4.setName("尼玛王");
            long entry_data = System.currentTimeMillis();
            student4.setUpdateAt(entry_data);
            student4.setUserId("CS-1233");
            int i = studentMapper.studyUpdate(student4);
            loggerTest.info("返回行数" + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("修改错误： "+e.getMessage());
        }
    }


    @Test
    public void studentDelete(){
        try {
            loggerTest.info("测试删除");
            StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
            int i = studentMapper.studyDelete("CS-1233");
            loggerTest.info("删除行数" + i);
        }catch (Exception e){
            e.printStackTrace();
            loggerTest.error("删除错误" + e.getMessage());
        }
    }

    @Ignore
    @Test
    public void ignore(){
        loggerTest.info("忽略此测试");
    }
}
