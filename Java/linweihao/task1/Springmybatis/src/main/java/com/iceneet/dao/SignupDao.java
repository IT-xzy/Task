package com.iceneet.dao;

import com.iceneet.Entity.signup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SignupDao {
    List<signup> selectSignup(String name);
    void insertSignup(signup signup);
    boolean updateSignup(String name,String name1);
    boolean deleteSignup(String name);
}
