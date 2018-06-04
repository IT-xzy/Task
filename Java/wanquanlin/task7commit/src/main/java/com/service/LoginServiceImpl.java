package com.service;

import com.DAO.LoginMapper;
import com.POJO.*;
import com.aliyun.oss.OSSClient;
import com.cache.RedisCacheUtil;
import com.util.aliyunutil.OssUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Autowired
    private RedisCacheUtil redisCacheUtil;
    @Autowired
    private OSSClient osscli;
    @Autowired
    private  OssUtil ossUtil;
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
            redisCacheUtil.hset("hash","images1", images1,60*60);
            return  images1;
        }else {
            return  redisCacheUtil.hget("hash","images1");
        }
    }

    public List<JobList> findJobList1() {
        if (redisCacheUtil.hget("hash","jobList")==null) {
            List<JobList> jobList=loginMapper.findJobList1();
            redisCacheUtil.hset("hash","jobList", jobList,60*60);
            return  jobList;
        }else {
            return  redisCacheUtil.hget("hash","jobList");
        }
    }
    public SignIn clientLogin(Long sign_id) {
        return loginMapper.clientLogin(sign_id);
    }
    public SignIn clientLogin2(String account) {
        return loginMapper.clientLogin2(account);
    }
    public String register(Register register,File targetFile){
       String url= ossUtil.uploadObjectToOSS(osscli,targetFile,"jaimewan","via"+register.getAccount());
       loginMapper.register(register);
            return url;
    }

}
