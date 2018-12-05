package com.service.ServiceImpl;

import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findStudent() {
        return studentDao.findStudent();
    }

    @Override
    public Long countStudent(Integer classifyId) {
        return studentDao.countStudent(classifyId);
    }
}
