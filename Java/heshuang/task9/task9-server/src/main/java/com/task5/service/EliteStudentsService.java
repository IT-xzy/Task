package com.task5.service;

import com.task5.pojo.EliteStudents;

import java.util.List;

public interface EliteStudentsService {
    List<EliteStudents> getAllStudents()throws Exception;
    int getStudyNumber()throws Exception;
    int getWorkNumber()throws Exception;
}
