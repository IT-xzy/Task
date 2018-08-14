import com.he.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    static Logger logger = Logger.getLogger(Test.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession = null;
    @Before
    public void setup() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }
   @org.junit.Test
    public void addStudent(){
        Student student = new Student();
        student.setCreate_at("1529117153");
        student.setName("小三");
        student.setQq("145800052");
        student.setProfessional("web");
        student.setStart_time("2018-03-25");
        student.setUniversity("西工大");
        student.setOnline_id(552);
        student.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student.setCounselor("李科");
        student.setCity("郑州");
        sqlSession.insert("mapper.addStudent",student);
        sqlSession.commit();
        logger.info(student.getId());
        sqlSession.close();
    }

    @org.junit.Test
    public void deleteStudent() {
        boolean flag;
        int i = sqlSession.delete("mapper.deleteStudent", 11);
        sqlSession.commit();
        if (i !=0){
            flag = true;
        }
        else flag =false;
        logger.info(flag);
        sqlSession.close();
        logger.info("关闭成功！！");
    }

    @org.junit.Test
    public void updateStudent() {
        boolean flag;
        Student student = new Student();
        student.setCreate_at("1529117255");
        student.setName("栗子");
        student.setQq("250000221");
        student.setId(15);
        int i = sqlSession.update("mapper.updateStudent", student);
        sqlSession.commit();
        if (i !=0){
            flag = true;
        }
        else flag = false;
        logger.info(flag);
        sqlSession.close();
    }
    @org.junit.Test
    public void findStudent(){
        List<Student>students = sqlSession.selectList("mapper.selectStudent");
        for (Student student:students){
            logger.info(student);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @org.junit.Test
    public void findStudentByOnline_id() {
        List<Student> students = sqlSession.selectList("mapper.findStudentByOnline_id", 255);
        for (int i = 0;i <students.size();i++){
            logger.info(students.get(i).toString());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void findStudentByName() {
        List<Student> students = sqlSession.selectList("mapper.findStudentByName", "张三");
        for (int i = 0; i < students.size(); i++) {
            logger.info(students.get(i).toString());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
