package com.mutesaid.service.impl;

import com.mutesaid.mapper.StudentMapper;
import com.mutesaid.pojo.Student;
import com.mutesaid.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    private Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Override
    public List<Student> getStudent() {
        return studentMapper.getStudent();
    }

    @Override
    public Student getById(Long id) {
        return studentMapper.getById(id);
    }

    @Override
    public Boolean deleteStudent(Long id) {
        try {
            studentMapper.deleteStudent(id);
            return true;
        }catch (Exception e) {
            logger.info(e);
            return false;
        }
    }

    @Override
    public Long addStudent(Student stu) {
        Long currentTime = System.currentTimeMillis();
        stu.setCreateAt(currentTime);
        stu.setUpdateAt(currentTime);
        studentMapper.addStudent(stu);
        return stu.getId();
    }

    @Override
    public Boolean updateStudent(Long id, String key, Object value) {
        Long currentTime = System.currentTimeMillis();
        try{
            studentMapper.updateStudent(id, key, value, currentTime);
            return true;
        }catch (Exception e) {
            logger.info(e);
            return false;
        }
    }
}
