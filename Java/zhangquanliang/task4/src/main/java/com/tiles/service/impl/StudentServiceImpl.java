package com.tiles.service.impl;

import com.tiles.dao.StudentDao;
import com.tiles.pojo.Student;
import com.tiles.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 23:33
 *
 * 学员 service的实现
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    /**
     * 查询全部学员
     */
    @Override
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }

    /**
     * 查询工作或者在学的学员总数  tag=1,在学，tag=0 工作
     *
     * @param tag
     */
    @Override
    public int getStudentType(Boolean tag) {
        return studentDao.getStudentType(tag);
    }
}
