package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import com.lihoo.ssm.util.AddSalt;
import com.lihoo.ssm.util.MD5Util;
import com.lihoo.ssm.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: StudentInfoServiceImpl
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-9:35
 */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentInfo> selectAll() {
        return studentInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentInfo record) {
        return studentInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(StudentInfo record) {
        return studentInfoMapper.insert(record);
    }

    @Override
    public Boolean verifyPwd(StudentInfo studentInfo) {
        StudentInfo studentInfo1 = studentInfoMapper.selectByUsername(studentInfo.getUsername());
        String salt = studentInfo1.getSalt();
        String loginPwdHash = getPwdHash(studentInfo.getPwd(), salt);
        return studentInfo1.getPwd().equals(loginPwdHash);
    }

    @Override
    public int updateLoginTimeById(StudentInfo studentInfo) {
        return studentInfoMapper.updateLoginTimeById(studentInfo);
    }

    @Override
    public StudentInfo selectByPrimaryKey(Long id) {
        return studentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudentInfo selectByUsername(String username) {
        return studentInfoMapper.selectByUsername(username);
    }

    @Override
    public StudentInfo selectByPwd(String pwd) {
        return studentInfoMapper.selectByPwd(pwd);
    }
}
