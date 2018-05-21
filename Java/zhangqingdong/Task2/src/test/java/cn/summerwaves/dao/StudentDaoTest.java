package cn.summerwaves.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void deleteStudent() {
//        System.out.println(studentDao.deleteStudent(2));
    }

    @Test
    public void delete() {
        System.out.println(studentDao.delete(3));
    }
}