package com.ppteng.service;

import com.ppteng.dao.StudentMapper;
import com.ppteng.pojo.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class CrudServiceImpl implements CrudService {
    private static   SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream inputStream = null;
            //得到配置文件的流
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    //插入一个学员信息并且打印日志
    public long addAStudent(Student student) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        student.setCreateAt(System.currentTimeMillis());
        studentMapper.insertStudent(student);
        sqlSession.commit();
        sqlSession.close();
        return student.getId();
    }

    //删除一个学员信息并且打印日志
    public boolean deleteAStudent(Long primeKey) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        boolean result = studentMapper.deleteStudent(primeKey);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    //通过主键来查询一个学员
    public Student findByPrimeKey(Long primekey) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findById(primekey);
        sqlSession.close();
        return student;
    }

    //通过姓名模糊查询
    public List<Student> findStudentsByName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.findByName(name);
        sqlSession.close();
        return students;
    }

    //通过学号精确查找
    public Student findAStudentByNum(String online_num) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findByNum(online_num);
        sqlSession.close();
        return student;
    }

    //更新信息
    public boolean updateInformation(Student student) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        student.setUpdateAt(System.currentTimeMillis());
        boolean result = studentMapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    //清空表格
    public void deleteAll() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.truncateTable();
        sqlSession.commit();
        sqlSession.close();
    }
}
