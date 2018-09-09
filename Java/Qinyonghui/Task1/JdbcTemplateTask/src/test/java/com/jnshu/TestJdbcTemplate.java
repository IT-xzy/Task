package com.jnshu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class TestJdbcTemplate {
    @Autowired
    StudentDaoImpl studentDaoImpl;
    @Test
    public void insertTest() {
        System.out.println(studentDaoImpl.insert(new Student("MaLin", 129890573, 13299073, "LiuGuoLiang", "chrome://settings/incompatibleApplicationsb2430e420517ff87a2758ec4b894e769a8ee4f13", "北京体育大学")));
    }

    @Test
    public void deletByIdTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.delete(29));
    }

    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
        boolean flag = studentDaoImpl.update(new Student(22, "LiuXiang",46575, 2068234534, "WangWeiDong", "chrome://settings20517ff87a2758ec4b", "工werwreew程大学"));
        System.out.println(flag);
    }

    @Test
    public void findTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.find(25));
    }
    @Test
    public void findAllTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.findAll());
    }
}
