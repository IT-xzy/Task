package com.ppteng.service;

import com.ppteng.dao.StudentDAO;
import com.ppteng.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CrudServiceImpl implements CrudService {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static StudentDAO studentDAO =(StudentDAO) ctx.getBean("studentDAO");

    public long addAStudent(Student student) throws Exception {
        student.setCreateAt(System.currentTimeMillis());
        return studentDAO.insertStudent(student);
    }

    //删除一个学员信息并且打印日志
    public boolean deleteAStudent(Long primeKey) throws Exception {
        return studentDAO.deleteStudent(primeKey);
    }

    //通过主键来查询一个学员
    public Student findByPrimeKey(Long primekey) throws Exception {
        return studentDAO.findById(primekey);
    }

    //通过姓名模糊查询
    public List<Student> findStudentsByName(String name) throws Exception {
        return studentDAO.findByName(name);
    }

    //通过学号精确查找
    public Student findAStudentByNum(String online_num) throws Exception {
        return studentDAO.findByNum(online_num);
    }

    //更新信息
    public boolean updateInformation(Student student) throws Exception {
        student.setUpdateAt(System.currentTimeMillis());
        return studentDAO.updateStudent(student);
    }

    //清空表格
    public void deleteAll() throws Exception {
        studentDAO.truncateTable();
    }
}
