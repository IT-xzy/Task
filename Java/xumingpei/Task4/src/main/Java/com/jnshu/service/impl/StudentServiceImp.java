package com.jnshu.service.impl;

import com.jnshu.dao.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 5:51
 */
@Service
public class StudentServiceImp implements StudentService {
    private static Logger logger = Logger.getLogger(StudentServiceImp.class);

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insertSelective(Student record) {
        return insertSelective(record);
    }

    @Override
    public List<Student> getAll() {
        List<Student> student = studentMapper.getAll();
        logger.info(toString());
        return student;
    }
}
