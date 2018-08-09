package wyq.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyq.springmvc.mapper.StudentMapper;
import wyq.springmvc.pojo.Student;
import wyq.springmvc.service.StudentService;
import wyq.springmvc.util.Page;

import java.util.List;

@Service
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

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

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
