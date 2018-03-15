package com.mybatis.mapper;

import com.mybatis.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;

/**
 * @author Arike
 * Create_at  2017/11/20 16:51
 */
public class StudentMapperTest {
    private SqlSession sqlSession;
    private StudentMapper sm;
    private Logger logger = Logger.getLogger(StudentMapperTest.class);
    
    @Before
    public void setup() throws Exception {
        Reader reader = Resources.getResourceAsReader("MyBaitsConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession(true);//设置为true表示自动提交事务.默认为false
        sm = sqlSession.getMapper(StudentMapper.class);
    }
    
    @Test
    public void getStudentById() throws Exception {
        
        System.out.println(sm.getStudentById(41));
    }
    
    @Test
    public void getStudentByName() throws Exception {
        System.out.println(sm.getStudentByName("%飞"));
    }
    
    @Test
    public void updateStudent() throws Exception {
        sm.updateStudent(new Student(67L, "刘德华", -20));
        
    }
    
    @Test
    public void insertStudent() throws Exception {
        Student s = new Student("悟饭", 18);
        sm.insertStudent(s);
        logger.debug("添加的ID为:" + s.getId());
    }
    
    @Test
    public void deleteStudent() throws Exception {
        
        sm.deleteStudent(new long[]{75, 76, 77});
    }
    
}