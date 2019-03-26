package com.ptteng.service.ServiceImpl;

import com.ptteng.dao.StudentMapper;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/26  17:59
 * @Version 1.0
 **/


@Service
public class StudentServiceImp implements StudentService {
@Autowired
StudentMapper studentMapper;
    @Override
    public List<Student> selectAll() {
        System.out.println("??????????????");
        System.out.println("################"+studentMapper);
        System.out.println(studentMapper.selectAll());
        return studentMapper.selectAll();
    }
}
