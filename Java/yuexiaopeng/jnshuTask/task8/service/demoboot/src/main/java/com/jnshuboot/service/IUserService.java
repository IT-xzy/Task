package com.jnshuboot.service;


import com.jnshuboot.pojo.Student;

import java.util.List;

public interface IUserService {

    List<Student> getUser(String studyId);

    Student selectById(Integer id);

    String test(String name);
}
