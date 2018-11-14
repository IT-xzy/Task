package com.wszhan.service.impl;

import com.wszhan.service.StudentService;
import com.wszhan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.wszhan.pojo.Student;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 10:28
 **/
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper mapper;

    public Student select(int id) throws Exception {
        return mapper.selectStudentById(id);
    }

    public int insert(Student student) throws Exception {
/*        System.out.println("Student: " + student +
                "\nName: " + student.getName() +
                "\nId: " + student.getId());*/
        mapper.insertStudent(student);
        return student.getId();
    }

    public boolean update(Student student) throws Exception {
        int bool;

        bool = mapper.updateStudentById(student);

        return bool > 0;
    }

    public boolean delete(int id) throws Exception {
        int bool;

        bool = mapper.deleteStudentById(id);

        return bool > 0;
    }

    public List<Student> selectAll() throws Exception {
        return mapper.selectStudentAll();
    }
}
