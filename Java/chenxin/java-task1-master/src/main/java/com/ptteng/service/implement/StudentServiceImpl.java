package com.ptteng.service.implement;

import com.mysql.jdbc.CommunicationsException;
import com.ptteng.dao.StudentDao;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
    public static StudentDao studentDao = applicationContext.getBean(StudentDao.class);

    //新增信息
    public boolean saveStudent(Student student) throws Exception {
        boolean returnValue=studentDao.saveStudent(student);
        return returnValue;
    }

    //删除信息
    public boolean removeStudent(String name) throws Exception {
            boolean returnValue=studentDao.removeStudent(name);
            return returnValue;
    }

    //    更新信息
    public boolean updateStudent(Student student) throws Exception {
        boolean returnValue=studentDao.updateStudent(student);
        return returnValue;
    }

    //更新名字
    public void updateStudentName(Long id, String name) throws Exception {
        Student student = studentDao.getStudentById(id);
        student.setName(name);
        studentDao.updateStudent(student);
    }

    //    通过id查找
    public Student getStudentById(Long id) throws Exception {
        return studentDao.getStudentById(id);
    }

    //通过名字或关键字查找，得到多个结果
    public List<Student> getStudentByName(String name) throws Exception {
        return studentDao.listStudentByName(name);
    }

    //通过学号得到一个学员
    public List<Student> getStudentByNumber(String number) throws Exception{
        return studentDao.getStudentByNumber(number);
    }
}