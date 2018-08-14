import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.pojo.Student;
import task.service.StudentService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestStudent
{
    static Logger logger=Logger.getLogger(TestStudent.class);
    @Autowired
    private StudentService studentService;
    @Test
    public void testInsertStudent()
    {
        Student student=new Student();
        student.setId(666);
        student.setCreateAt(20180608l);
        student.setUpdateAt(20180608l);
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");
        student.setStudyId("j-689");
        student.setJoinTime(20180608l);
        student.setUniversity("火星殖民地");
        student.setDailyLink("http://www.google.com");
        student.setSlogen("我的征途是星辰大海啊");
        student.setMaster("嗨，大师兄");
        studentService.insertStudent(student);
        logger.info(student);
    }
    @Test
    public void deleteStudent()
    {
        String studyId="j-686";
        int i=studentService.deleteStudent(studyId);
        logger.info(i);
    }
    @Test
    public void updateStudent()
    {
        Student student=new Student();
        student.setStudyId("j-686");
        student.setMaster("wuKong");
        student.setDailyLink("www.baidu.com");
        student.setSlogen("qiTian");
        int i=studentService.updateStudent(student);
        logger.info(i);
    }
    @Test
    public void selectStudent()
    {
        String studyId="j-686";
        Student student=studentService.selectStudent(studyId);
        logger.info(student);
    }
    @Test
    public void selectAllStudent()
    {
        List<Student> studentList=studentService.selectAllStudent();
        for(Student student:studentList)
        {
            logger.info(student);
        }
    }
    @Test
    public void selectAllStudentPage()
    {

        PageHelper.startPage(1,5);
        List<Student> studentList=studentService.selectAllStudent();
        for(Student student:studentList)
        {
            logger.info(student);
        }
        Long total=new PageInfo(studentList).getTotal();
        logger.info(total);
    }
}
