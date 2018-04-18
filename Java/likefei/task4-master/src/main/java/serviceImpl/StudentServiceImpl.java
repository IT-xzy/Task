package serviceImpl;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
StudentMapper studentMapper;

    public List<Student> list(){ return  studentMapper.list(); }

    @Override
    public void add(Student student) {
    studentMapper.add(student);
    }

    @Override
    public void delete(int id)  {
     studentMapper.delete(id);
    }

    @Override
    public  Student get(int id) {
        return studentMapper.get(id);
    }

    @Override
    public void update(Student student)  { studentMapper.update(student); }

    @Override
    public void pinsert(List<String> list) { }

    @Override
    public int gettotal(){ return  studentMapper.gettotal();}

    @Override
    public int getjavatotal() {return studentMapper.getjavatotal();}
}


