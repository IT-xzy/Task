package com.dao;

import com.pojo.t_studentPro;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from t_studentPro")
    List<t_studentPro> findAlls();

}
