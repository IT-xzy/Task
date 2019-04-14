package com.ptteng.service.impl;

import com.ptteng.dao.StudentMapper;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  11:39
 * @Version 1.0
 **/
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectBySalary(Long figure) {
        System.out.println("进来没============================="+figure);
        return studentMapper.selectBySalary(figure);
    }



    @Override
    public int selectCount() {
        return studentMapper.selectCount();
    }

    @Override
    public int selectCountBySalary(Long  income) {
        return studentMapper.selectCountBySalary(income);
    }
}
