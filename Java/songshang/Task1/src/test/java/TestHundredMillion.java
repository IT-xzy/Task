import com.entity.Student;
import com.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 22:58
 * @version: [1.0]
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class TestHundredMillion {

    @Autowired
    StudentService studentService;
    @Test
    public void TestHundredMillion(){
        Student student = new Student();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10000; i++){
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
        long end = System.currentTimeMillis();

        start = (start - end)/1000;
        System.out.println("共花费" + start + "秒");
    }

}
