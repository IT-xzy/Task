package com.tiles.mapper;

import com.tiles.pojo.Students;

import java.util.List;

public interface StudentsDao {
    List<Students> getAllStudents()throws Exception;
    int getStudyNumber()throws Exception;
    int getWorkNumber()throws Exception;
}
