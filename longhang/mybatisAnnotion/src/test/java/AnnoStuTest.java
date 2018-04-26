import mapper.AnnotionStudentMapper;
import model.Student;
import mybatisTool.MybatisTool;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
public class AnnoStuTest
{
    private static Logger logger = Logger.getLogger("MybatisTestTest.class");
    @Test
    public void insert() {
        //SQL 的语句insert into students (id,name,qq,wish,create_at)
        SqlSession session = MybatisTool.getSession();
        AnnotionStudentMapper mapper = session.getMapper(AnnotionStudentMapper.class);
        Student student = new Student(201L, "张三", "244558", "修仙", 2018L);
        mapper.insert(student);
        session.commit();
        session.close();
        logger.info(student.toString());
    }

}
