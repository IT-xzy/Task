package com.dao;

import org.apache.ibatis.annotations.Select;

import com.pojo.t_studentPro;

import java.util.List;

public interface StudentPro {
    //方法查找所有
    @Select("select * from t_studentPro ")
    List<t_studentPro> findAlls();
}
