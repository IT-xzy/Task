package cn.wyq.service.impl;

import cn.wyq.mapper.StudentMapper;
import cn.wyq.pojo.Student;
import cn.wyq.service.StudentService;
import cn.wyq.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

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

//    @Override
//    public void updateStudent(Student student) {
//        studentMapper.update(student);
//    }

    public List<Student> list(){
        return studentMapper.list();
    }

    @Override
    public List<Student> list(Page page){
        System.out.println("list请求");
        return studentMapper.list(page);
    }

    @Override
    public int total(){
        System.out.println("total请求");
        return studentMapper.total();
    }
}
