package jnshu.service;


import jnshu.model.ExcellentStudent;

import java.util.List;


public interface StudentService {
    int insertStudent(ExcellentStudent record);
    //    查询优秀学员信息
    List<ExcellentStudent> selectStudent();

}
