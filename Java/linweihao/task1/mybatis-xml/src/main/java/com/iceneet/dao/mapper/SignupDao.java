package com.iceneet.dao.mapper;

import com.iceneet.Entity.signup;

import java.util.List;
import java.util.Map;

public interface SignupDao {
    List<signup> selectSignup(String name);
    void insertSignup(signup signup);
    boolean updateSignup(Map paramMap);
    boolean deleteSignup(String name);
}
