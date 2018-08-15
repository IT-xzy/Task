import com.annotation.dao.StudentDao;
import com.annotation.untils.MybatisUntils;
import com.he.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestAnnotation {
    static Logger logger = Logger.getLogger(TestAnnotation.class);
    @Test
    public void findAll()throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student>students = studentDao.list();
        sqlSession.commit();
        for (Student student:students){
            logger.info(student);
        }
        sqlSession.close();
    }
    @Test
    public void addStudent()throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setCreate_at("1154472102");
        student.setName("小三");
        student.setQq("11451451121");
        student.setProfessional("web");
        student.setStart_time("2018-03-25");
        student.setUniversity("西工大");
        student.setOnline_id(552);
        student.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student.setCounselor("李科");
        student.setCity("郑州");
        studentDao.add(student);
        sqlSession.commit();
        logger.info(student.getId());
        sqlSession.close();
    }
    @Test
    public void deleteStudent() throws IOException{
        boolean flag;
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Integer i = studentDao.delete(22);
        sqlSession.commit();
        if (i !=0){
            flag = true;
        }else flag = false;
        logger.info(flag);
        sqlSession.close();
    }
    @Test
    public void updateStudent()throws IOException{
        boolean flag;
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("陈雯雯");
        student.setId(26);
        Integer i = studentDao.update(student);
        sqlSession.commit();
        if (i !=0){
            flag = true;
        }else flag = false;
        logger.info(flag);
        sqlSession.close();
    }
    @Test
    public void findByName()throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student>students = studentDao.findByName("张三");
        sqlSession.commit();
        for (Student student:students){
            logger.info(student);
        }
        sqlSession.close();
    }
    @Test
    public void findByOnline_id()throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisUntils.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student>students = studentDao.findByOnline_id(255);
        sqlSession.commit();
        for (Student student:students){
            logger.info(student);
        }
        sqlSession.close();
    }
}
