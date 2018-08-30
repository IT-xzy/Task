package com.lihoo.ssm.dao;

import com.lihoo.ssm.model.StudentProfession;
import java.util.List;

public interface StudentProfessionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StudentProfession record);

    StudentProfession selectByPrimaryKey(Long id);

    List<StudentProfession> selectAll();

    int updateByPrimaryKey(StudentProfession record);


    //    ****
    int countAll();

    List<StudentProfession> findJob();
}