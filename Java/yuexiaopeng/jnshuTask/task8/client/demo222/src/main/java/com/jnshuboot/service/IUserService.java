package com.jnshuboot.service;

import com.jnshuboot.pojo.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("iUserService")
public interface IUserService {

    List<Student> getUser(String studyId);

    Student selectById(Integer id);

    String test(String name);
}
