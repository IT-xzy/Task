package com.service;

import com.mapper.StudentMapper;
import com.util.Page;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void deleteStudentById(int id){
        try {
            studentMapper.deleteStudent(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudentList(){
        return studentMapper.list();
    }

    @Override
    public Student getStudentById(int id){
        try {
            return studentMapper.findStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertStudent(Student student){
        try {
            studentMapper.insertStuden(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student){
        try {
            studentMapper.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTotal(){
        return studentMapper.total();
    }

    @Override
    public List<Student> getStudentListByPage(Page page){
        return studentMapper.list(page);
    }

}
