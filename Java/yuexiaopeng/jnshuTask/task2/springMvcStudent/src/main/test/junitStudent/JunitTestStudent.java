package junitStudent;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxpStu.pojo.Student;
import com.yxpStu.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class JunitTestStudent
{
    static Logger logger=Logger.getLogger(JunitTestStudent.class);

    @Autowired
    private StudentService studentService;

    @Test
    public void insertStudentTest()
    {
        Student student=new Student();
        student.setId(666);
        student.setCreateAt(20180608l);
        student.setUpdateAt(20180608l);
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");

        student.setStudyId("java-684");
        student.setJoinTime(20180608l);
        student.setUniversity("葡萄藤修真院");
        student.setDailyLink("http://www.jnshu.com/school/22071/daily");
        student.setSlogen("我的征途是星辰大海啊");
        student.setMaster("嗨，大师兄");
        studentService.insertStudent(student);
        logger.info("插入一条数据记录成功");
    }

    @Test
    public void deleteStudentTest()
    {
        Student student=new Student();
        String studyId="java-680";
        student.setStudyId(studyId);
        studentService.deleteStudent(student);
        logger.info("删除studyId为:"+studyId+"  数据记录成功");
    }

    @Test
    public void updateStudentTest()
    {
        Student student=new Student();

        student.setStudyId("java-682");
        student.setSlogen("仰望苍穹");
        student.setMaster("主席");
        student.setDailyLink("wwww.baidu.com");
        studentService.updateStudent(student);
        logger.info("修改成功，修改后的student为 ： "+student);
    }
    @Test
    public void selectStudent()
    {
        Student student=new Student();
        String studyId="java-678";
        student.setStudyId(studyId);
        Student student1=studentService.selectStudent(student);
        logger.info("查询成功，数据为"+student1);
    }
    @Test
    public void selectAllTest()
    {
        PageHelper.startPage(1,2);
        List<Student> stu=studentService.selectAllStudent();
        for(Student stu1:stu)
        {
            logger.info(stu1);
        }
        Long i=new PageInfo(stu).getTotal();
        logger.info(i);
    }
}
