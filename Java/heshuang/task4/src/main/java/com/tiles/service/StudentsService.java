package com.tiles.service;

import com.tiles.pojo.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAllStudents()throws Exception;
    int getStudyNumber()throws Exception;
    int getWorkNumber()throws Exception;
}
