package test;

import com.hzw.mapper.StudentMapper;
import com.hzw.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    @Before
    /*创建会话工厂*/
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
    }

    @Test
    //增
    public void addStu(){
        logger.info("测试添加=====================");
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setS_name("李龙");
        student.setS_qq(26262637);
        student.setS_type("OP");
        student.setS_num(587);
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.addStu(student);
        sqlSession.commit();
//        System.out.println(student.getS_id());
        logger.info(student.getS_id());
        sqlSession.close();
    }

    @Test
    //删
    public void deleteStu(){
        logger.info("测试删除=====================");
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        long s_id = 26;
        boolean i = studentMapper.deleteStu(s_id);
        sqlSession.commit();
//        System.out.println(i);
        logger.info(i);
        sqlSession.close();
    }

    @Test
    //改
    public void updateStu(){
        logger.info("测试更新=====================");
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setS_name("王梅梅");
        student.setS_qq(87342978);
        student.setS_type("UI");
        student.setS_num(161);
        student.setUpdate_at(System.currentTimeMillis());
        student.setS_id(19);
        boolean i =studentMapper.updateStu(student);
        sqlSession.commit();
//        System.out.println(i);
        logger.info(i);
        sqlSession.close();
    }

    @Test
    //查id
    public void getId(){
        logger.info("测试查询id=====================");
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        long s_id = 19;
        Student student = studentMapper.getId(s_id);
//        System.out.println(student);
        logger.info(student);
        sqlSession.close();
    }

    @Test
    //查所有
    public void getAll(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stu = studentMapper.getAll();
        for(Student s:stu){
//            System.out.println(s);
            logger.info(s.toString());
        }
        sqlSession.close();
    }

    @Test
    //查name
    public void getName() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.Student("李龙",587);
        List<Student> list = studentMapper.getName(student);
        for(Student s:list){
            logger.info(s.toString());
        }
        sqlSession.close();
    }
}
