package com.zyq.daoImpl;

import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private static Logger logger = LogManager.getLogger(MybatisTest.class);
    private StudentDao studentDao;
    private SqlSession sqlSession;
    private Student student;

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
        student = new Student();
    }

    @After
    public void endMethod(){
        sqlSession.commit();
        sqlSession.close();
        logger.info("测试日志输出");
    }

    @Test
    public void testInsert(){
        student.setName("程荣强");
        student.setQq(1312901692);
        student.setProfession("web工程师");
        student.setUniversity("天津科技大学");
        student.setNumber(264);
        student.setDaily("http://www.jnshu.com/school/22071/daily");
        student.setSenior("禚洪宇");
        student.setFrom("知乎");
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        studentDao.insert(student);
        System.out.println("您插入的数据ID为："+student.getId()+",请牢记。");
    }

    @Test
    public void testDeleteById(){
        student.setId(81L);
        boolean flag = studentDao.deleteById(student);
        if (flag == false){
            System.out.println("删除失败，没有此行。");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void testUpdate(){
        student.setName("程荣强");
        student.setUpdateTime(System.currentTimeMillis());
        boolean flag = studentDao.update(student);
        if (flag == false){
            System.out.println("更新失败，没有此行。");
        }else {
            System.out.println("更新成功");
        }
    }

    @Test
    public void testSelectById(){
        student = studentDao.selectById(43L);
        if (student==null){
            System.out.println("根据您输入的ID，查无此人，请确认是否输入错误");
        }else {
            System.out.println(student);
            logger.info(student);
        }
    }

    @Test
    public void selectByNameAndNum(){
        List<Student> list = studentDao.selectByNameAndNum("程荣强",264);
        if (list.size()!=0) {
            for (Student student : list) {
                System.out.println(student);
            }
        }else {
            System.out.println("根据您的条件，数据表中查无此人。");
        }
    }
}
