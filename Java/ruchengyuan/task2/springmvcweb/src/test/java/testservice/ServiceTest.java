package testservice;

import com.tasktwo.model.Student;
import com.tasktwo.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * Created by Administrator on 30/7/2017.
 */


//单元测试不会自动加载spring配置文件，需要手动导入
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ServiceTest {

    @Autowired
    private StudentService studyService;

    private static Logger loggerTest = Logger.getLogger(Test.class);

    @BeforeClass
    public static void begin(){
        loggerTest.info("测试开始");
    }

    @AfterClass
    public static void end(){
        loggerTest.info("测试结束");
    }



    @Test
    public void detail() {
        try {
            loggerTest.info("查找用户信息");
            loggerTest.info("JAVA-1111");
            Student study = this.studyService.getUserId("JAVA-1111");
            loggerTest.info(study);
        }catch (Exception e) {
            e.printStackTrace();
            loggerTest.error("查询失败" + e.getMessage());
        }
    }


    @Test
    public void insert() {
        try {
            Student study = new Student();
            loggerTest.info("添加用户信息");
            study.setUserId("PM-8811");
            study.setName("林毛之家");
            study.setGraduated("河北大学");
            study.setKnowFrom("百度");
            study.setQq(77889900);
            study.setStudyType(4);
            study.setUrl("www.10086.cn");
            study.setWish("啊哈");
            int i = studyService.studyInsert(study);
            loggerTest.info("study" + study);
            loggerTest.info("添加信息的行数" + i);
        }catch(Exception e){
            e.printStackTrace();
            loggerTest.error("添加出错" + e.getMessage());
        }
    }


    @Test
    public void update(){
        try {
            loggerTest.info("修改用户信息");
            Student study = new Student();
            study.setName("王坤");
            study.setUserId("PM-8811");
            int i = studyService.studyUpdate(study);
            loggerTest.info("study" + study);
            loggerTest.info("返回修改行数" + i);
        }catch(Exception e){
            e.printStackTrace();
            loggerTest.error("修改出错" + e.getMessage());
        }
    }
    @Test
    public void delete(){
        try {
            loggerTest.info("删除用户信息");
            int i = studyService.studyDelete("PM-8811");
            loggerTest.info("返回影响行数" + i);
        }catch(Exception e){
            e.printStackTrace();
            loggerTest.error("" + e.getMessage());
        }
    }


    @Test
    public void all(){
        try {
            loggerTest.info("查询全部学生信息");
            List<Student> study = studyService.studentAll();
            loggerTest.info("studylist ： " + study);
            int i = study.size();
            loggerTest.info("返回用户数量" + i);
        }catch(Exception e){
            e.printStackTrace();
            loggerTest.error("查询错误" + e.getMessage());
        }
    }

}
