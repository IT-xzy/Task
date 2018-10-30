package com.task5.mapper;

import com.task5.pojo.EliteStudents;
import java.util.List;

public interface EliteStudentsDao {
    List<EliteStudents> getAllStudents()throws Exception;
    int getStudyNumber()throws Exception;
    int getWorkNumber()throws Exception;
}
