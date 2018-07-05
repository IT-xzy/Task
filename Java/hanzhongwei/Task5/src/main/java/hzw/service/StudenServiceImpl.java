package hzw.service;

import hzw.DAO.StudentMapper;
import hzw.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudenServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> findStudent() throws IOException {
        return studentMapper.findStudent();
    }
}
