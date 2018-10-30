package com.jnshuboot.service.imp;

import com.jnshuboot.dao.StudentMapper;
import com.jnshuboot.pojo.Student;
import com.jnshuboot.pojo.example.StudentExample;
import com.jnshuboot.service.IUserService;
import com.jnshuboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired(required = false)
    StudentMapper studentMapper;

    @Override
    public List<Student> getUser(String studyId) {
        Student student = new Student();
        student.setStudyId(studyId);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudyIdEqualTo(studyId);
        List<Student> list = studentMapper.selectByExample(studentExample);
        log.info("rmi:查询的student数据为 :" + list);
        return list;
    }

    @Override
    public Student selectById(Integer id) {
        Student student1 = new Student();
        //根据学生studyId查询学生数据，studyId不为空
        List<Student> studentList = new ArrayList<>();
        StudentExample studentExample = new StudentExample();

        try {
            studentExample.createCriteria().andIdEqualTo(id);
            studentList = studentMapper.selectByExample(studentExample);
            //数据不存在时，会出现index异常；
            student1 = studentList.get(0);
            log.info("rmi:从数据库查询的id为:{}的student数据成功!", id);
            return student1;
        } catch (IndexOutOfBoundsException e) {
            //没有数据出现的index异常
            log.error("rmi:从数据库查询的id为{}的student数据不存在", id);
        }
        return student1;
    }

    @Override
    public String test(String name) {
        log.info("远程rmi执行的关键字为 :" + name);
        return name;
    }
}
