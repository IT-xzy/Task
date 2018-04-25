import longhang.dao.StudentMapper;
import longhang.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class springDbcpMybatisTest
{
    //private static Logger logger = Logger.getLogger(SpringMybatisTestTest.class);
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void insert() {
        //studentMapper.insert(new Student(5000L,"张三", "244558", "修仙", 2018L));
        //SQL 的语句insert into students (id,name,qq,wish,create_at);
        for(long x=1;x<10;x++)
        {
            studentMapper.insert(new Student(Long.valueOf(x),"张三", "244558", "修仙", 2018L));

        }

        //logger.info(student.toString());
    }
    @Test
    public void update() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        Student student = new Student(9L, "厉害");
        studentMapper.update(student);
    }
    @Test
    public void delete() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        studentMapper.delete(271L);
    }
    @Test
    public void select() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        Student student = studentMapper.select(3L);
        // logger.info(student.toString());
    }
    @Test
    public void getAll() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}

        List<Student> student = studentMapper.getAll();
        Iterator<Student> it = student.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            //  logger.info("" + it.next());
        }
        //logger.info(student.toString());
    }
}
