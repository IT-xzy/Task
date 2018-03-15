package com.student.service;

import com.student.dao.StudentDao;
import com.student.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StudentServiceIpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public int deleteByPrimaryKey(Long id){
        return studentDao.deleteByPrimaryKey(id);
    }

    public int insert(Student student){
        return studentDao.insert(student);
    }

    public int insertSelective(Student record){
        return studentDao.insertSelective(record);
    }

    public Student selectByPrimaryKey(Long id){
        return studentDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Student record){
        return studentDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student student){
        return studentDao.updateByPrimaryKey(student);
    }

    public List<Student> getAll(){
        return studentDao.getAll();
    }
}
