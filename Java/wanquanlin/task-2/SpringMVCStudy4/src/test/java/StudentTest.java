import com.DAO.StudentMapper;
import com.POJO.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
//@RunWith就是一个运行器
//@RunWith(JUnit4.class)就是指用JUnit4来运行
//@RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
//@RunWith(Suite.class)的话就是一套测试集合
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/StudentBeans.xml")
public class StudentTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findUserById() throws IOException {

        Student student = studentMapper.findUserById(1l);
        System.out.println(student);

    }

   /* @Test
    public void findUserByName() throws IOException {
        List<Student> student = studentMapper.findUserByName("Pony");
        System.out.println(student);
    }*/
   @Test
   public void selectcount2() throws Exception {
       int a=studentMapper.selectCount2("李");
       System.out.println(a);
   }
    @Test
    public void deleteUser() throws Exception {
        int a=studentMapper.deleteUser(55);
        System.out.println(a);
    }
    @Test
    public void updateUser() throws Exception {
        Student student=new Student(null,"我的",23333l,"sapm-10",8678L,
                "snsdao","bdiasundka",
                "sndoasl","22",null,null);
        student.setID(15l);
        int a=studentMapper.updateUser(student);
        System.out.println(a);
    }
    @Test
    public void insertUser() throws Exception {
           Long time=System.currentTimeMillis();
        Student student=new Student(null,"ta的",224,"sapm-11",231412685L,
                "asaf","bdiasundka",
                "saca","22",time,null);
        for(int i=0;i<10;i++) {
            studentMapper.insertUser(student);
            Long a = student.getID();

          System.out.println(a);
        }
    }
}
