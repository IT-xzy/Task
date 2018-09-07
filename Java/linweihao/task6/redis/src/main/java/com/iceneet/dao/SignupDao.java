package com.iceneet.dao;


import com.iceneet.entity.Signup;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SignupDao {
    List<Signup> selectSignup( @Param("start")int start, @Param("limit")int limit);
    List<Signup> GetSignAll();
    Signup GetSignupById(long id);
    int insertSignup(Signup signup);
    int deleteSignupById(long id);
    int updateByPrimaryKey(Signup signup);
    boolean updateSignup(String name, String name1);
    boolean deleteSignup(String name);
}
