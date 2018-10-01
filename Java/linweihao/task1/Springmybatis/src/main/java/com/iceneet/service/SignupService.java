package com.iceneet.service;


import com.iceneet.Entity.signup;
import com.iceneet.dao.SignupDao;
import org.springframework.beans.factory.annotation.Autowired;

public class SignupService {
    @Autowired
    private SignupDao signupDao;
//
//    public signup SelectById(String name){
//        signup signup = signupDao.selectSignup(name);
//        return signup;
//    }

    public void InsertSignup(signup signup){
        signupDao.insertSignup(signup);
    }
    public boolean UpdateSignup(String name,String name1){
        return signupDao.updateSignup(name,name1);
    }
    public boolean DeleteSignupById(String name){
        return signupDao.deleteSignup(name);
    }
}
