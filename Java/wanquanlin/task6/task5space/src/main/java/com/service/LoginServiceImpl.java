package com.service;

import com.DAO.LoginMapper;
import com.POJO.*;


import com.cache.RedisCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    //task-5
    public List<GoodStudent> findGood(){
   return loginMapper.findGood();
    }

    public int selectCount() {
        return loginMapper.selectCount();
    }
    public int selectCountGraduate(){
        return loginMapper.selectCountGraduate();
    }

    public List<Images1> findImgaes1() {
        if (redisCacheUtil.hget("hash","images1")==null) {
            List<Images1> images1=loginMapper.findImgaes1();
            redisCacheUtil.hset("hash","images1", images1);
            return  images1;
        }else {
            return (List<Images1>) redisCacheUtil.hget("hash","images1");
        }
    }

    public List<JobList> findJobList1() {
        if (redisCacheUtil.hget("hash","jobList")==null) {
            List<JobList> jobList=loginMapper.findJobList1();
            redisCacheUtil.hset("hash","jobList", jobList);
            return  jobList;
        }else {
            return (List<JobList>) redisCacheUtil.hget("hash","jobList");
        }

    }

    public SignIn clientLogin(Long sign_id) {
        return loginMapper.clientLogin(sign_id);
    }
    public SignIn clientLogin2(String account) {
        return loginMapper.clientLogin2(account);
    }
    public int register(SignIn signIn){

        return loginMapper.register(signIn);
    }

}
