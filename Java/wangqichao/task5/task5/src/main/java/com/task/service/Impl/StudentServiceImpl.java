package com.task.service.Impl;

import com.task.dao.StudentDao;
import com.task.models.Student;
import com.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
@Autowired
    private StudentDao studentDao;
    @Override
    public int justAdd(Student student) throws Exception {
       studentDao.addStudent(student);
       return student.getId();
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Boolean justUpdate(Student student) throws Exception {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student justListById(int id) throws Exception {
        Student student=studentDao.getStudent(id);
        return student;
    }

    @Override
    public List<Student> justList(String name) throws Exception {
        List<Student> list=studentDao.getByName(name);
        return list;
    }

    @Override
    public Student justListByStuID(int stuID) throws Exception {
        return studentDao.getByStuID(stuID);
    }

    @Override
    public int listCount() throws Exception {
        return studentDao.selectCount();
    }

    @Override
    public int listIsStudy() throws Exception {
        return studentDao.selectIsStudy();
    }

    @Override
    public int listIsStuByPro(String profession) throws Exception {
        return studentDao.selectIsStuByPro(profession);
    }
}
