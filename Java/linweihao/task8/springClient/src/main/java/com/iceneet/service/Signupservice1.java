package com.iceneet.service;

import com.weihao.entity.Signup;

import java.util.List;

import com.weihao.entity.Signup;

import java.util.List;
public interface Signupservice1 extends Service{
    List<Signup> getSignupByPage(int start, int limit);
    Signup GetSignupById(long id) ;
    int updateByPrimaryKey(Signup signup) ;
    int InsertSign(Signup signup) ;
    List<Signup> getSignAll();
    int DeleteById(long id) ;
}

