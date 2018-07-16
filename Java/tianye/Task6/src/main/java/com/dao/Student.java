package com.dao;

import com.pojo.t_student;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface Student {
    //方法查找所有
    @Select("select * from t_student ")
    List<t_student> findAll();
    }
