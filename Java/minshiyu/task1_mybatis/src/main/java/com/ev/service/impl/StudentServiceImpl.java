package com.ev.service.impl;

import com.ev.service.StudentService;
import com.ev.bean.Student;
import com.ev.dao.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static StudentMapper studentMapper = context.getBean(StudentMapper.class);

    //插入一个学员信息并且返回主键
    public long addAStudent(Student student) throws Exception{
        try {
            student.setCreateAt(System.currentTimeMillis());
            studentMapper.insertStudent(student);
            return student.getId();
        } catch (DuplicateKeyException e){
            //插入学员时可能发生的异常
            throw new DuplicateKeyException("Insert failed ,id exists.");
        }
    }

    //删除一个学员信息
    public boolean deleteAStudent(Long primeKey) throws Exception{
        return studentMapper.deleteStudent(primeKey);
    }

    //通过主键来查询一个学员
    public List<Student> findByPrimeKey(Long primeKey) throws Exception{
        return studentMapper.findById(primeKey);
    }

    //通过姓名模糊查询
    public List<Student> findAStudentsByName(String name) throws Exception{
        return studentMapper.findByName(name);
    }

    //通过学号精确查找
    public List<Student> findAStudentByNumber(String online_num)  throws Exception{
        return studentMapper.findByNumber(online_num);
    }

    //更新信息
    public boolean updateInformation(Student student) throws Exception{
        student.setUpdateAt(System.currentTimeMillis());
        return studentMapper.updateStudent(student);
    }

    //清空表格
    public void reset() throws Exception {
        studentMapper.reset();
    }

}
