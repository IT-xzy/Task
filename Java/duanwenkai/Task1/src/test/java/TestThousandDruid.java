import com.entity.Student;
import com.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:    配置Druid连接池的MaBatis插入1000条记录测试。最大链接数20
 * @ClassName:      向user表中插入1000条数据，总共执行了492毫秒
 * @author: fml<duanweikai>
 * @date: 2018/3/6 20:23
 * @version: [1.0]
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class TestThousandDruid {
    @Autowired
    StudentService studentService;

    @Test
    public void TestUserAdd(){
        Student student = new Student();
        //student.setId(2);
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        student.setStuName("bbb");
        student.setQQ("666666666");
        student.setLessonType(2);
        student.setAdmissionTime(System.currentTimeMillis());
        student.setGraduatedSchool("bbb");
        student.setStuNumber("666");
        student.setDiaryLink("https://666");
        student.setWish("学学学");
        student.setBrotherId(1);
        student.setHeardFrom("知乎");

        long a = System.currentTimeMillis();

        studentService.add(student);

        long b = System.currentTimeMillis();
        a = b - a;//总共执行了1051毫秒
        System.out.println("总共执行了" + a + "毫秒");
    }

}
