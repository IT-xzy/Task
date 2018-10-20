package com.lihoo.ssm.service;

import com.lihoo.ssm.model.StudentList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * #Title: StudentListService
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-18:25
 */

@Component
public interface StudentListService {
    int deleteByPrimaryKey(Long id);

    int insert(StudentList record);

    StudentList selectByPrimaryKey(Long id);

    List<StudentList> selectAll();

    int updateByPrimaryKey(StudentList record);

    List<StudentList> getJavaList();

    List<StudentList> getWebList();
}
