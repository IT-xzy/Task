package com.myJDBC.dao;

import com.myJDBC.dao.impl.StudentDAOImpl;
import com.myJDBC.domain.Student;
import org.junit.Test;

/**
 * @author Arike
 * Create_at  2017/11/14 11:13
 */
public class IMyMappingTest {
    private IStudentDAO dao = new StudentDAOImpl();
    
    @Test
    public void add() throws Exception {
        dao.add(new Student(0,"白瘦",18));
    }
    
    @Test
    public void delete() throws Exception {
        dao.delete(6L);
    }
    
    @Test
    public void update() throws Exception {
        dao.update(new Student(8L,"邓婕人",7));
    }
    
    @Test
    public void get() throws Exception {
        Student stu = dao.get(41);
        System.out.println(stu);
    }
    
    @Test
    public void getall() throws Exception {
        System.out.println(dao.getall());
    }
    
    @Test
    public void test() throws Exception{
        String s ="\\w+\\.";
        System.out.println("lkjadlkajd45564.".matches(s));
    }
    
}