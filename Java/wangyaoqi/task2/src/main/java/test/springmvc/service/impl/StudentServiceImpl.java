package test.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springmvc.mapper.StudentMapper;
import test.springmvc.pojo.Student;
import test.springmvc.service.StudentService;
import test.springmvc.util.Page;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    public  StudentMapper getStudentMapper(){
        return studentMapper;
    }
    public  void  setStudentMapper(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }
    @Override
    public void addStudent(Student student) {
        studentMapper.add(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentMapper.getOne(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    public List<Student> list(){
        return studentMapper.list();
    }
//    @Override
//    public List<Student> list(Page page){
//        return studentMapper.list(page);
//    }
//
//    @Override
//    public int total(){
//        return studentMapper.total();
//    }
}
