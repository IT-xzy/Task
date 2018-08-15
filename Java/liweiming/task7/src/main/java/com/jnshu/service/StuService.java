package com.jnshu.service;

import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;

import java.util.List;

/**
 * @program: Tiles
 * @description: 业务逻辑
 * @author: Mr.Lee
 * @create: 2018-06-29 10:18
 **/

public interface StuService {

    List<Student> findAll();
    List<Profession> findAlls();

    /**
     * @Description: 统计在学、工作
     * @Param: []
     * @return: java.lang.Integer
     * @Author: Mr.Wang
     * @Date: 2018\6\29 0029
     */
    Integer stuCount();
    Integer workCount();
}
