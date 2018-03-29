package Service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.model.Student;
import task.jnshu.service.StudentService;

import java.util.List;


/**
 * Created by Administrator on 7/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StudyService {
    private static Logger LoggerSSS = Logger.getLogger(StudyService.class);

    @Autowired
    private StudentService studyService;


    @Test
    public void studentSelect(){
        try{
            Student study =  this.studyService.studentSelect(1);
            LoggerSSS.info("查询学员信息为：" + study);
        }catch (Exception e){
            e.printStackTrace();
            LoggerSSS.info("e.getMessage()  " + e.getMessage());
        }

    }

    @Test
    public void studentNumber(){
        try{
            //0为找到工作的状态：graduation
            //-1是查询所有学员数量：entire
            int graduation = studyService.selectStudentNumber(0);
            int entire = studyService.selectStudentNumber(null);
            LoggerSSS.info("找到工作人数：" + graduation);
            LoggerSSS.info("累计在学人数：" + entire);
        }catch (Exception e){
            e.printStackTrace();
            LoggerSSS.info("e.getMessage()  " + e.getMessage());
        }

    }


    @Test
    public void studentAll(){
        try{
            List<Student> students = studyService.studentAll();
            LoggerSSS.info("返回学生信息： \n" + students);
        }catch (Exception e){
            e.printStackTrace();
            LoggerSSS.error("e.getMessage() " + e.getMessage());
        }
    }
}
