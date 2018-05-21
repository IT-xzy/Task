import com.longhang.MybatisTest.mapper.StudentMapper;
import com.longhang.MybatisTest.model.Student;
import com.longhang.MybatisTest.tools.MybatisTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.Iterator;
import java.util.List;
public class MybatisTestTest {
    private static Logger logger = Logger.getLogger("MybatisTestTest.class");
    @Test
    public void insert() {
        //SQL 的语句insert into students (id,name,qq,wish,create_at)
        SqlSession session = MybatisTools.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = new Student(201L, "张三", "244558", "修仙", 2018L);
        studentMapper.insert(student);
        session.commit();
        session.close();
        logger.info(student.toString());
    }
    @Test
    public void update() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        SqlSession session = MybatisTools.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = new Student(9L, "厉害");
        studentMapper.update(student);
        session.commit();
        session.close();
    }
    @Test
    public void delete() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        SqlSession session = MybatisTools.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.delete(2501L);
        session.commit();
        session.close();
    }
    @Test
    public void select() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        SqlSession session = MybatisTools.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.select(3L);
        logger.info(student.toString());
        session.commit();
        session.close();
    }
    @Test
    public void getAll() {
        //SQL 的语句update student set wish=#{wish} where Id=#{id}
        SqlSession session = MybatisTools.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> student = studentMapper.getAll();
        Iterator<Student> it = student.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            logger.info("" + it.next());
        }
        //logger.info(student.toString());
        session.commit();
        session.close();
    }
}


