package ServiceImpl;

import dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    public int count() {
        return studentMapper.count();
    }


    public Student select(int id) {
         return studentMapper.select(id);
    }
}