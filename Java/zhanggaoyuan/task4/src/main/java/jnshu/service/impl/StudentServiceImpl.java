package jnshu.service.impl;

import jnshu.dao.ExcellentStudentMapper;
import jnshu.model.ExcellentStudent;
import jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    ExcellentStudentMapper studentMapper;

    @Override
    public int insertStudent(ExcellentStudent record) {
        return studentMapper.insert (record);
    }

    @Override
    public List<ExcellentStudent> selectStudent() {
        return studentMapper.selectStudent ();
    }
}
