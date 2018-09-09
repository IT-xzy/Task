package com.jnshu;

import org.junit.Test;

import java.sql.SQLException;

public class TestStudentDaoImpl {
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    @Test
    public void insertTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.insert(new Student("MaLin",129890573,13299073,"LiuGuoLiang","chrome://settings/incompatibleApplicationsb2430e420517ff87a2758ec4b894e769a8ee4f13","北京体育大学")));
    }

    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.delete(5l));
    }

    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
       boolean flag = studentDaoImpl.update(new Student(2l,"LiuXiang",2137,2306,"WangWeiDong","chrome://settings20517ff87a2758ec4b","中国"));
       System.out.println(flag);
    }
    @Test
    public void findTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.find(10));
    }

    @Test
    public void findAllTest() throws SQLException, ClassNotFoundException {
        System.out.println(studentDaoImpl.findAll());
    }
}
