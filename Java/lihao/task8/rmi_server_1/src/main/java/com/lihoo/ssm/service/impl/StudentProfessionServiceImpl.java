package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentProfessionMapper;
import com.lihoo.ssm.model.StudentProfession;
import com.lihoo.ssm.service.StudentProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #Title: StudentProfessionServiceImpl
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/29-14:54
 */

@Service
public class StudentProfessionServiceImpl implements StudentProfessionService {

    @Autowired
    StudentProfessionMapper studentProfessionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentProfessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StudentProfession record) {
        return studentProfessionMapper.insert(record);
    }

    @Override
    public StudentProfession selectByPrimaryKey(Long id) {
        return studentProfessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentProfession> selectAll() {
        return studentProfessionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentProfession record) {
        return studentProfessionMapper.updateByPrimaryKey(record);
    }




    @Override
    public int countAll() {
        return studentProfessionMapper.countAll();
    }

    @Override
    public List<StudentProfession> findJob() {
        return studentProfessionMapper.findJob();
    }
}
