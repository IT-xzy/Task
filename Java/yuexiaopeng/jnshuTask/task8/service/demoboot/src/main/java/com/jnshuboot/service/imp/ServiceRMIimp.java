package com.jnshuboot.service.imp;

import com.jnshuboot.dao.StudentMapper;
import com.jnshuboot.pojo.Student;
import com.jnshuboot.pojo.example.StudentExample;
import com.jnshuboot.service.ServiceRMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRMIimp implements ServiceRMI {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudent(int id) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdEqualTo(id);
        List<Student> list = studentMapper.selectByExample(studentExample);
        return list;
    }
}
