package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentHomeMapper;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.service.StudentHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #Title: StudentHomeServiceImpl
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-13:06
 */

@Service
public class StudentHomeServiceImpl implements StudentHomeService {

    @Autowired
    StudentHomeMapper studentHomeMapper;


    @Override
    public List<StudentHome> selectGreatStudent() {
        return studentHomeMapper.selectGreatStudent();
    }

    @Override
    public StudentHome selectByPrimaryKey(Long id) {
        return studentHomeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int workingCount() {
        return studentHomeMapper.workingCount();
    }

    @Override
    public int countAll() {
        return studentHomeMapper.countAll();
    }

    @Override
    public List<StudentHome> selectAll() {
        return studentHomeMapper.selectAll();
    }
}
