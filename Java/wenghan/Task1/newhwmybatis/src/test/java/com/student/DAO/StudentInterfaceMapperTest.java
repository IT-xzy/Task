package com.student.DAO;

import com.student.DAO.Student;
import com.student.DAO.StudentInterfaceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class StudentInterfaceMapperTest {
    SqlSession sqlSession=null;
    boolean i=false;
    boolean operationResult=false;
    private static Logger logger=Logger.getLogger(Test.class);
    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
    }
    //全表查询
    @Test
    public void selectAllStudent() {
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        List<Student> list=studentInterfaceMapper.selectAllStudent();
        logger.info(list);
    }

    //插入一个学生
    @Test
    public void insertOneStudent() {
        Student student=new Student();
        student.setName("小明");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        studentInterfaceMapper.insertOneStudent(student);
        System.out.println(student.getId());
    }

    //根据ID号删除一个学生
    @Test
    public void deleteOneStudentForId() {
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        i=studentInterfaceMapper.deleteOneStudentForId(2272008);
    }

    //更新一个学生
    @Test
    public void updateOneStudentForId() {
        Student student=new Student();
        student.setId(5);
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("王小二");
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        i=studentInterfaceMapper.updateOneStudentForId(student);
        System.out.println(i);
    }

    //注解方式插入一个学生
    @Test
    public void insertStudentAnnotation() {
        Student student=new Student();
        student.setName("安文艺");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        logger.info(studentInterfaceMapper.insertStudent(student));
    }

    //注解方式更新一个学生
    @Test
    public void updateStudentAnnotation() {
        Student student=new Student();
        student.setName("小青");
        student.setId(2);
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        operationResult=studentInterfaceMapper.updateStudent(student);
        System.out.println(operationResult);
    }

    //注解方法删除一个学生
    @Test
    public void deleteStudentAnnotation() {
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        operationResult=studentInterfaceMapper.deleteStudent(4);
        System.out.println(operationResult);
    }

    //注解方式根据ID找到一个学生
    @Test
    public void findStudentByIdAnnotation() {
        StudentInterfaceMapper studentInterfaceMapper=sqlSession.getMapper(StudentInterfaceMapper.class);
        Student student=studentInterfaceMapper.findStudentById(3);
        System.out.println(student);
    }
}