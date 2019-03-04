package com.jnshu.service;

import com.jnshu.beans.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    void addStu(Student student);

    boolean delStuById(Integer id);

    boolean updateStuTypeById(Integer id,String type,Long updateAt);


    Student selectStuById(Integer id);

    Student selectStuAll();

    Student selectStuByName(String name);

    Student selectStuByOnlineNumber(Integer onlineNumber);



}
