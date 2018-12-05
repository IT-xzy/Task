package com.tiles.service;

import com.tiles.pojo.Student;

import java.util.List;

/**
 * @author tiles
 * @date 2018/11/16 22:32
 * 学员的service
 */
public interface StudentService {

    /**
     * 查询全部学员
     */
    public List<Student> listStudent();

    /**
     * 查询工作或者在学的学员总数  tag=1,在学，tag=0 工作
     */
    public  int  getStudentType(Boolean tag);
}
