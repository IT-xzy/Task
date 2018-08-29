package com.lihoo.ssm.service;


import com.lihoo.ssm.model.StudentProfession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentProfessionService {

    int deleteByPrimaryKey(Long id);

    int insert(StudentProfession record);

    StudentProfession selectByPrimaryKey(Long id);

    List<StudentProfession> selectAll();

    int updateByPrimaryKey(StudentProfession record);


    //    ****
    int countAll();

    List<StudentProfession> findJob();
}
