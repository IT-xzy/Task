package com.lihoo.ssm.service;

import com.lihoo.ssm.model.StudentInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentInfoService {
    int deleteByPrimaryKey(Long id);

    List<StudentInfo> selectAll();

    int updateByPrimaryKey(StudentInfo record);

    int insert(StudentInfo studentInfo);

    StudentInfo selectByPrimaryKey(Long id);

    StudentInfo selectByUsername(String username);

    StudentInfo selectByPwd(String pwd);

    Boolean verifyPwd(StudentInfo studentInfo);

    int updateLoginTimeById(StudentInfo studentInfo);

}
