
import com.student.StudentMapper;
import com.student.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.util.List;

public class StudentLog4jTest {
    private ApplicationContext applicationContext;
    private static Logger log=Logger.getLogger(StudentLog4jTest.class);

    @Before
    public void setup() {

        applicationContext = new ClassPathXmlApplicationContext("com/student/StudentBeans.xml");

    }

    @Test
    public void findUserById() throws IOException {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("userMapper");
        Student student = studentMapper.findUserById(2);
        log.info(student);

    }

    @Test
    public void findUserByName() throws IOException {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("userMapper");
        List<Student> student = studentMapper.findUserByName("Pony");
        System.out.println(student);
    }

    @Test
    public void deleteUser() throws Exception {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("userMapper");
        int a=studentMapper.deleteUser(55);
        System.out.println(a);
    }
    @Test
    public void updateUser() throws Exception {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("userMapper");
        Student student=new Student(23333,"sapm-10",8678L,
        "snsdao","bdiasundka",
                "sndoasl","22",null);
        student.setID(1l);
        int a=studentMapper.updateUser(student);
        System.out.println(a);
    }
/*    @Test
    public void insertUser() throws Exception {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("student");
        Student student=new Student("ta的",224,"sapm-11",231412685L,
                "asaf","bdiasundka",
                "saca","22",null,null);
      for(int i=0;i<10;i++) {
          studentMapper.insertUser(student);
          Long a = student.getID();
          log.info(a);
//          System.out.println(a);
      }
    }*/
}