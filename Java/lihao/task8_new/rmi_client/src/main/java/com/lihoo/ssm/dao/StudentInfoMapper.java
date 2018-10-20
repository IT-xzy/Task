package com.lihoo.ssm.dao;

import com.lihoo.ssm.model.StudentInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lihoo
 */
@Component
public interface StudentInfoMapper {

    int deleteByPrimaryKey(Long id);

    List<StudentInfo> selectAll();

    int updateByPrimaryKey(StudentInfo record);

    int insert(StudentInfo record);

    StudentInfo selectByPrimaryKey(Long id);

    StudentInfo selectByUsername(String username);

    StudentInfo selectByPwd(String pwd);

    int updateLoginTimeById(StudentInfo studentInfo);

}