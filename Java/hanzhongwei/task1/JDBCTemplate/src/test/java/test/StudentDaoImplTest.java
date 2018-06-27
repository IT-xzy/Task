package test;

import com.hzw.dao.StudentDao;
import com.hzw.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/*让测试在Spring容器环境下执行*/
/*@RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，
为了便于使用spring的依赖注入，
spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/*从类路径下加载applicationContext.xml*/
@ContextConfiguration("classpath:applicationContext.xml")

public class StudentDaoImplTest {
    @Resource(name = "studentDao")
    private StudentDao sd;
    //上边就把我们要测试的对象sd注入进来了

    @Test
    public void addStu(){
        Student student = new Student();
        student.setS_name("王梅梅");
        student.setS_qq(871237864);
        student.setS_type("UI");
        student.setS_num(188);
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        sd.addStu(student);
    }

    @Test
    public void deleteStu(){
        long s_id = 29;
        sd.deleteStu(s_id);
    }

    @Test
    public void updateStu(){
        Student student = new Student();
        student.setS_id(28);
        student.setS_name("李斯明");
        student.setS_qq(871237657);
        student.setS_type("OP");
        student.setS_num(166);
        student.setUpdate_at(System.currentTimeMillis());
        sd.updateStu(student);
    }

    @Test
    public void getId() {
        Student student;
        long s_id = 28;
        student = sd.getId(s_id);
        System.out.println(student);
    }

    @Test
    public void getAll(){
        List<Student> list;
        list = sd.getAll();
        System.out.println(list);
    }
}
