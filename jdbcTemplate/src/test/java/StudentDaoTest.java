import com.longhang.Task2.model.Student;
import com.longhang.Task2.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.List;
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest
{
    @Resource
   private StudentDao studentDao;
    @Test
    public void testInsert()
    {
        Student student=new Student();
        student.setName("大刘");
        student.setCreate_at(2065L);
        student.setWish("变聪明");
        student.setQq("2154854");
        int result=studentDao.insert(student);
        System.out.println(result);
    }
    @Test
    public void testUpdate()
    {
        Student student=new Student();
        student.setId(7L);
        student.setWish("你你很牛逼");
        int result=studentDao.update(student);
        System.out.println(result);
    }
    @Test
    public void testDelete() {
        Long id = 18L;
        int result = studentDao.delete(id);
        System.out.println(result);
    }

    @Test
    public void testSelect()
    {
        Long id=7L;
        Student student=studentDao.select(id);
        System.out.println(student.toString());
    }


    @Test
    public void testGetAll() {
        List<Student> students = studentDao.getAll();
        for (Student item : students) {
            System.out.println(item);
        }
    }
}
