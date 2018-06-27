package hzw.service.impl;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import hzw.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentSerivce{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public void addStu(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.addStu(student);
    }

    @Override
    public void deleteStu(long stuId) {
        studentMapper.deleteStu(stuId);
    }

    @Override
    public void updateStu(Student student) {
        System.out.println(student.toString());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.updateStu(student);
    }

    @Override
    public Student getId(long stuId) {
        System.out.println("进来没");
        return studentMapper.getId(stuId);
    }
}
