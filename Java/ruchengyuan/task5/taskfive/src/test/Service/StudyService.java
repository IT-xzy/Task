package Service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.model.Student;
import task.jnshu.service.StudentService;
import task.jnshu.utils.Md5Utils;

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
            LoggerSSS.error("e.getMessage()  " + e.getMessage());
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

    @Test
    public void selectUser(){
        Student study = studyService.selectUser("789456");
        LoggerSSS.info("study: "+study);
    }

    @Test
    public void selectUserNumber(){
        String user = "qwe";
        int i = studyService.selectUserNumber(user);
            LoggerSSS.info("用户名为：" + user + "有"+ i + "个");
    }

    @Test
    public void insertStudent(){
        Student study = new Student();
        study.setUser("789456");
        Md5Utils md5 = new Md5Utils();
        String pass = "1111111";
        pass = md5.getMD5(pass);
        study.setPass(pass);
        Integer qq = 56789;
        study.setQq(qq);
        int i = studyService.insertSelective(study);
        LoggerSSS.info("返回添加信息" + i);
    }
}
