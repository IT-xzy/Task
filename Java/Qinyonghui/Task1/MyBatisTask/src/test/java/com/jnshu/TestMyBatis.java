package com.jnshu;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

public class TestMyBatis{
        String resource = "config.xml";
        InputStream is = TestMyBatis.class.getClassLoader().getResourceAsStream(this.resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(this.is);
        SqlSession session = sessionFactory.openSession();
        StudentMapper dao = session.getMapper(StudentMapper.class);

    @Test
    public void insertTest() throws SQLException, ClassNotFoundException {

        Student student = new Student("MaLin",129890573,13299073,"LiuGuo","settingsincompatible","北京体育大学",System.currentTimeMillis(), System.currentTimeMillis());
//        System.out.println(student.toString());
        dao.insert(student);
        this.session.commit();
        System.out.println(student.getId());
        this.session.close();
    }

    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException {
        System.out.println(this.dao.delete(1));
        this.session.commit();
        this.session.close();
    }

    @Test
    public void updateTest() throws SQLException, ClassNotFoundException {
        String str = "com.jnshu.StudentMapper.update";
        Student student = new Student(2,"MaLin",1234,13299073,"LiuGuoLiang","b2430e420517ff87a2758ec4b894e769a8ee4f13","北京体育大学",System.currentTimeMillis());
//        System.out.println(student.toString());
        System.out.println(dao.update(student));
        this.session.commit();
        this.session.close();
    }

    @Test
    public void findTest() throws SQLException, ClassNotFoundException {
        System.out.println(this.dao.find(21));
    }

    @Test
    public void findAllTest() throws SQLException, ClassNotFoundException {
        List student = this.dao.findAll();
        System.out.println(student);
        this.session.close();
    }
}
