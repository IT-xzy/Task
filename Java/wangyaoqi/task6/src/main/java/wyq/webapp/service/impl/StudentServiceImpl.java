package wyq.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wyq.webapp.mapper.StudentMapper;
import wyq.webapp.pojo.Student;
import wyq.webapp.service.StudentService;
import wyq.webapp.util.Page;

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
        return studentMapper.list(page);
    }

    @Override
    public int total(){
        return studentMapper.total();
    }
}
