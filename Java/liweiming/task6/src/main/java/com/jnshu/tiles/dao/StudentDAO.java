package com.jnshu.tiles.dao;

import com.jnshu.tiles.entity.Profession;
import com.jnshu.tiles.entity.Student;

import java.util.List;

/**
 * @program: Tiles
 * @description: 学员接口
 * @author: Mr.Lee
 * @create: 2018-06-29 10:20
 **/
public interface StudentDAO {

    /**
    * @Description: 学员信息
    * @Param: []
    * @return: java.util.List<com.jnshu.tiles.entity.Student>
    * @Author: Mr.Wang
    * @Date: 2018\6\29 0029
    */
    List<Student> findAll();

    //获取profession全部信息

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
