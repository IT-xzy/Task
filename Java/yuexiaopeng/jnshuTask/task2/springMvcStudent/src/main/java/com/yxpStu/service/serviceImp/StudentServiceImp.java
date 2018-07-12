package com.yxpStu.service.serviceImp;

import com.yxpStu.dao.StudentDao;
import com.yxpStu.pojo.Student;
import com.yxpStu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService
{
    @Autowired
    private StudentDao studentDao;

    public int insertStudent(Student student)
    {
        return studentDao.insertStudent(student);
    }

    public void deleteStudent(Student student)
    {
        studentDao.deleteStudent(student);
    }

    public int updateStudent(Student student)
    {
        return studentDao.updateStudent(student);
    }

    public Student selectStudent(Student student)
    {
        return studentDao.selectStudent(student);
    }

    public List<Student> selectAllStudent()
    {
        return studentDao.selectAllStudent();
    }
}
