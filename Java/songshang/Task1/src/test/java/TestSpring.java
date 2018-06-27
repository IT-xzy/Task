import com.entity.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/6 13:49
 * @version: [1.0]
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class TestSpring {
    /**测试spring整合mybatis之前，请放开注释掉的注解部分包括service和dao*/

    @Autowired
    StudentService studentService;

    //StudentService studentService = new StudentServiceImpl();
    @Test
    public void TestStudentAdd(){
        Student student = new Student();
        //student.setId(2);
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        student.setStuName("ccc");
        student.setQQ("222222222");
        student.setLessonType(2);
        student.setAdmissionTime(System.currentTimeMillis());
        student.setGraduatedSchool("ccc");
        student.setStuNumber("199");
        student.setDiaryLink("https://ccc");
        student.setWish("学学学");
        student.setBrotherId(1);
        student.setHeardFrom("知乎");

        studentService.add(student);
    }

    @Test   /**删除之前请看一下数据库有没有这条信息*/
    public void TestStudentDelete(){
        studentService.delete(4);
    }

    @Test
    public void TestUpdate(){
        Student student = studentService.selectById(496);
        System.out.println(student.getStuName());
    }
}
