package com.jnshu.service;
import com.jnshu.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> studentList();
    Student selectByName(String Name);
    int insert(Student record);
    int deleteById(Integer id);
    Student selectById(Integer id);
    int upPortraitByPhone(String url, String name);
    int upPortraitByEmail(String portrait, String email);
    String selectPortraitByName(String name);
    String selectPortraitByPhone(String telphone);
}
