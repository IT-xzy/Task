package com.mybatis.DAO;

import com.mybatis.DAO.impl.StudentDAOImp;
import com.mybatis.bean.Student;
import org.junit.Test;

/**
 * @author Arike
 * Create_at  2017/11/20 14:42
 */
public class IStudentDAOTest {
    public IStudentDAO dao = new StudentDAOImp();
    
    @Test
    public void insertStudent() throws Exception {
        dao.insertStudent(new Student("张飞",23));
    }
    
    @Test
    public void deleteStudent() throws Exception {
      dao.deleteStudent(52);
    }
    
    @Test
    public void updateStudent() throws Exception {
        dao.updateStudent(new Student(41,"飞天小女警",5));
    }
    
    @Test
    public void selectOne() throws Exception {
        dao.selectOne(41);
    }
    
    @Test
    public void selectAll() throws Exception {
        dao.selectAll("%飞");
    }
    
}