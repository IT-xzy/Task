package com.jnshu.task2.service;

import com.jnshu.task2.beans.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void addStu(Student student);

    boolean delStuById(Integer id);

    boolean updateStuTypeById(Integer id, Student student);


    Student selectStuById(Integer id);

    List<Student> selectStuAll();

    Student selectStuByName(String name);

    Student selectStuByOnlineNumber(Integer onlineNumber);

    List<Student> selectStuByPage(Integer start,Integer pageSize);

}
