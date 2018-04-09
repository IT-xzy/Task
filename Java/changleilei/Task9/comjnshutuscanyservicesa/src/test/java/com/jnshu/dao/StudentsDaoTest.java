package com.jnshu.dao;

import com.jnshu.model.Students;
import com.jnshu.services.Impl.StudentsServicesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring-mybatis.xml")
public class StudentsDaoTest {
    @Resource
    private StudentsDao studentsDao;
    @Resource
    private StudentsServicesImpl studentsServices;

    @Test
    public void deleteById() throws Exception {
//        int s = studentsDao.deleteById(1l);
        int s = studentsServices.deleteById(1l);
        System.out.println(s);
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void updateByIdSelective() throws Exception {
    }

    @Test
    public void updateById() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
        List<Students> students = studentsServices.selectAll();
        Iterator it = students.iterator();
        while (it.hasNext()) {
            Students students1 = (Students) it.next();
            System.out.println(students1.toString());
        }
    }

    @Test
    public void updateByName() throws Exception {
    }

}